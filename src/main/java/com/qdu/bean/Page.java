package com.qdu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
	private int pageNum; // 当前页
	private int pageSize;
	private List<T> rows;
	private long total; // 总记录数
	private int pageCount; // 总页数
	private int pre; // 上一页
	private int next; // 下一页
	private boolean first; // 首页
	private boolean last; // 尾页
}
