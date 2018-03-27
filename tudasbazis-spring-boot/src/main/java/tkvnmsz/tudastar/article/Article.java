package tkvnmsz.tudastar.article;

import java.util.List;

public class Article {
	private String title;
	private String content;
	private int languageId;
	private ChangeKind changeKind;
	private int categoryId;

	private int id;
	private String date;
	private int topicId;
	private int writerId;
	private boolean overviewed;
	private List<Integer> keywordIDs;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public ChangeKind getChangeKind() {
		return changeKind;
	}

	public void setChangeKind(ChangeKind changeKind) {
		this.changeKind = changeKind;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public boolean isOverviewed() {
		return overviewed;
	}

	public void setOverviewed(boolean overviewed) {
		this.overviewed = overviewed;
	}

	public List<Integer> getKeywordIDs() {
		return keywordIDs;
	}

	public void setKeywordIDs(List<Integer> keywordIDs) {
		this.keywordIDs = keywordIDs;
	}

}