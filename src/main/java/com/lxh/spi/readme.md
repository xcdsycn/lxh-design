文件名：spi.View，内容：

spi.HtmlView
spi.TextView
4.将上述具体实现类按照SPI规范打成jar文件（即包含META-INF/services以及类信息）

先将实现类的.class文件，service信息等放到一个目录中，目录结构如下：

.
├── META-INF
│   └── services
│       └── spi.View
└── spi
    ├── HtmlView.class
    └── TextView.class
然后用jdk自带的jar指令进行打包，生成一个view.jar：

jar cvf view.jar .

5.将view.jar加入classpath中，运行Main方法

.
├── spi
│   ├── Main.class
│   └── View.class
└── view.jar
java -classpath $CLASS_PATH:view.jar spi.Main

得到输出结果如下：

html view
text view