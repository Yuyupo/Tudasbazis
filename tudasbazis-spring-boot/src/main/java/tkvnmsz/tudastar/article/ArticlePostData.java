package tkvnmsz.tudastar.article;

import java.util.List;

public class ArticlePostData {
	private String title;
	private String content;
	private List<Integer> keywordIds;
	private int languageId;
	private ChangeKind changeKind;
	private int categoryId;
	private int parentArticleId;

	public int getParentArticleId() {
		return parentArticleId;
	}

	public void setParentArticleId(int parentArticleId) {
		this.parentArticleId = parentArticleId;
	}

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

	public List<Integer> getKeywordIds() {
		return keywordIds;
	}

	public void setKeywordIds(List<Integer> keywordIds) {
		this.keywordIds = keywordIds;
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
		return "ArticlePostData [title=" + title + ", content=" + content + ", keywordIds=" + keywordIds
				+ ", languageId=" + languageId + ", changeKind=" + changeKind + ", categoryId=" + categoryId + "]";
	}

}
