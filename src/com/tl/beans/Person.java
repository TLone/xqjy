package com.tl.beans;
/**
 * ���ڴ洢��ȡ���ı���Ͷ�Ӧ������
 * @author Tomcat
 *
 */
public class Person {
	private String title;
	private String link;
	
	public Person()	{}
	public Person(String title,String link){
		this.title=title;
		this.link=link;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLink() {
		return link;
	}

}
