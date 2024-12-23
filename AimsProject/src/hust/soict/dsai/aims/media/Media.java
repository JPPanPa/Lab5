package hust.soict.dsai.aims.media;
import java.util.Comparator;
public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Media(int id, String title, String category, float cost) {
		this.id=id;
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof Media)) return false;
	    Media other = (Media) obj;
	    return this.getTitle() != null && this.getTitle().equals(other.getTitle());
	}
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public void play() {
		// TODO Auto-generated method stub
		
	}
}
