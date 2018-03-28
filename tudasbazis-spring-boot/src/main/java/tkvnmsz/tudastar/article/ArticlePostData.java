package tkvnmsz.tudastar.article;

import java.util.List;

public class ArticlePostData {
	private String title;
	private String content;
	private List<String> keywords;
	private int languageId;
	private ChangeKind changeKind;
	private int categoryId;

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

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
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

	@Override
	public String toString() {
		return "ArticlePostData [title=" + title + ", content=" + content + ", keywords=" + keywords + ", languageId="
				+ languageId + ", changeKind=" + changeKind + ", categoryId=" + categoryId + "]";
	}
	
}
