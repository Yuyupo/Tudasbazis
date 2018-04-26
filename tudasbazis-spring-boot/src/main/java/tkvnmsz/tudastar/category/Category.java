package tkvnmsz.tudastar.category;

public class Category {
	private int id;
	private String name;
	private int parentId;
	private int numberOfArticles = -1;

	public Category(int id, String name, int parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public Category() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String category) {
		this.name = category;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getNumberOfArticles() {
		return numberOfArticles;
	}

	public void setNumberOfArticles(int numberOfArticles) {
		this.numberOfArticles = numberOfArticles;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	}

}
