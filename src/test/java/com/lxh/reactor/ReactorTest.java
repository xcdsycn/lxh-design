package com.lxh.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class ReactorTest {

	@Test
	public void test() {
		Flux.just(1, 2, 3, 4).subscribe(System.out::print);
		Mono.just(1).subscribe(System.out::print);
		Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::println, System.err::println,
				() -> System.out.println("Completed!"));

		Mono.error(new Exception("mono error")).subscribe(System.out::println, System.err::println,
				() -> System.out.println("Complete"));
	}

	private Flux<Integer> generateFluxFrom1To6() {
		return Flux.just(1, 2, 3, 4, 5, 6);
	}

	private Mono<Integer> generateMonoWithError() {
		return Mono.error(new Exception("some error"));
	}

	@Test
	public void testViaStepVerifier() {
		StepVerifier.create(generateFluxFrom1To6()).expectNext(1, 2, 3, 4, 5, 6).expectComplete().verify();
		StepVerifier.create(generateMonoWithError()).expectErrorMessage("some error").verify();

		StepVerifier.create(Flux.range(1, 6) // 1
				.map(i -> i * i)) // 2
				.expectNext(1, 4, 9, 16, 25, 36) // 3
				.expectComplete();
		StepVerifier.create(Flux.just("flux", "mono").flatMap(s -> Flux.fromArray(s.split("\\s*")) // 1
				.delayElements(Duration.ofMillis(200))) // 2
				.doOnNext(System.out::print)) // 3
				.expectNextCount(8) // 4
				.verifyComplete();
	}

	private Flux<String> getZipDescFlux() {
		String desc = "Zip two sources together, that is to say wait for all the sources to emit one element and combine these elements once into a Tuple2.";
		return Flux.fromArray(desc.split("\\s+")); // 1
	}

	@Test
	public void testSimpleOperators() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(1); // 2
		Flux.zip(getZipDescFlux(), Flux.interval(Duration.ofMillis(200))) // 3
				.subscribe(t -> {
					System.out.println(t.getT1());
					System.out.println(t.getT2());
				}, null, countDownLatch::countDown); // 4
		countDownLatch.await(10, TimeUnit.SECONDS); // 5
	}

	private String getStringSync() {
		try {
			TimeUnit.SECONDS.sleep(2);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello, Reactor!";
	}

	@Test
	public void testSyncToAsync() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		Mono.fromCallable(() -> getStringSync()) // 1
				.subscribeOn(Schedulers.elastic()) // 2
				.subscribe(System.out::println, null, countDownLatch::countDown);
		countDownLatch.await(10, TimeUnit.SECONDS);
	}

	@Test
	public void exceptionHandler() {
		// 返回一个替换整型值
		Flux.range(1, 6).map(i -> 10 / (i - 3)).onErrorReturn(0) // 1
				.map(i -> i * i).subscribe(System.out::println, System.err::println);
		// 返回一个新的流
		Flux.range(1, 6).map(i -> 10 / (i - 3)).onErrorResume(e -> Mono.just(new Random().nextInt(6))) // 提供新的数据流
				.map(i -> i * i).subscribe(System.out::println, System.err::println);

		// finally
		LongAdder statsCancel = new LongAdder(); // 1

		Flux<String> flux = Flux.just("foo", "bar").doFinally(type -> {
			if (type == SignalType.CANCEL) { // 2
				statsCancel.increment(); // 3
				System.out.println("cancel for this flow...");
			}
		}).take(1); // 4
	}

}
