package com.yiyong.framework.core.common;

public class Node {
	private String title; //节点名称
	private String key;	//节点ID
	private boolean isFolder = false;//是否有子节点，注意getter/setter方法，不要改动
	private boolean expand = false; //初始化树形时是否展开
	private boolean hideCheckbox = false; //是否隐藏checkbox
	private boolean unselectable = false; //是否可选
	private String url;//节点链接URL
	private boolean select = false;//初始化树形时是否已经选中
	private Node[] children;//子节点数组
	private boolean isLazy = false;//是否需要延迟加载，（注意getter/setter方法，不要改动）,与 onLazyRead()配合使用, when the node is expanded for the first time to allow for delayed creation of children.


	
	public Node()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	 
	public boolean isExpand()
	{
		return expand;
	}
	public void setExpand(boolean expand)
	{
		this.expand = expand;
	}
	public boolean isHideCheckbox()
	{
		return hideCheckbox;
	}
	public void setHideCheckbox(boolean hideCheckbox)
	{
		this.hideCheckbox = hideCheckbox;
	}
	public boolean isUnselectable()
	{
		return unselectable;
	}
	public void setUnselectable(boolean unselectable)
	{
		this.unselectable = unselectable;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public boolean isSelect()
	{
		return select;
	}
	public void setSelect(boolean select)
	{
		this.select = select;
	}
	public Node[] getChildren()
	{
		return children;
	}
	public void setChildren(Node[] children)
	{
		this.children = children;
	}
	public boolean getIsFolder()
	{
		return isFolder;
	}
	public void setIsFolder(boolean isFolder)
	{
		this.isFolder = isFolder;
	}
	public boolean getIsLazy()
	{
		return isLazy;
	}
	public void setIsLazy(boolean isLazy)
	{
		this.isLazy = isLazy;
	}
}
