package es.uco.pw.display.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class PostBean implements Serializable {

	private static final long serialVersionUID = 1L;
	int id;
	String title;
	String creatorMail;
	String author;
	String content;
	Timestamp created_at;

	public PostBean() {
		id = -1;
		title = ""; //$NON-NLS-1$
		creatorMail = ""; //$NON-NLS-1$
		content = ""; //$NON-NLS-1$
		author = ""; //$NON-NLS-1$
		
		created_at = new Timestamp(0L);
	}

	public PostBean(int id, String title, String creatorMail, String author, String content, Timestamp created_at) {
		super();
		this.id = id;
		this.title = title;
		this.creatorMail = creatorMail;
		this.content = content;
		this.created_at = created_at;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatorMail() {
		return creatorMail;
	}

	public void setCreatorMail(String creatorMail) {
		this.creatorMail = creatorMail;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
}
