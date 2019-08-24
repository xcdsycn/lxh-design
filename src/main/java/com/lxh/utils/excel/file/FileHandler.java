package com.lxh.utils.excel.file;

import java.io.FileInputStream;

/**
 * 文件处理
 *
 * @author lxh
 */
public interface FileHandler {

	/**
	 * 保存文件
	 * @param fileInputStream
	 * @return 返回文件标识或文件相对路径
	 */
	String save(FileInputStream fileInputStream);

	/**
	 * 删除文件
	 * @param fileId 文件的ID
	 */
	void delete(String fileId);

}
