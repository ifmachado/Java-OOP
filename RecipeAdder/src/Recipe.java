
//this class implements the comparable interface
public class Recipe implements Comparable<Recipe> {
	// global variables for recipe name and booleans that will indicate if recipe
	// has dairy, meat or gluten.
	private String name = "";
	private boolean dairy;
	private boolean meat;
	private boolean gluten;

	// recipe constructor
	public Recipe(String mName, boolean mDairy, boolean mMeat, boolean mGluten) {
		name = mName;
		dairy = mDairy;
		meat = mMeat;
		gluten = mGluten;

	}

	// name getter
	public String getName() {
		return name;
	}

	// name setter
	public void setName(String mName) {
		name = mName;
	}

	// dairy setter - if true, means it has dairy.
	public boolean hasDairy() {
		return dairy;
	}

	// meat setter - if true, means it has meat.
	public boolean hasMeat() {
		return meat;
	}

	// gluten setter - if true, means it has gluten.
	public boolean hasGluten() {
		return gluten;
	}

	// returns true if recipe is vegan (dairy and meat == false)
	public boolean isVegan(Recipe rec) {
		if (rec.hasDairy() == false && rec.hasMeat() == false) {
			return true;
		}

		else {
			return false;
		}
	}

	// overrides compareTo method, so lists sorted will show vegan recipes first,
	// then vegetarian, then meat.
	@Override
	public int compareTo(Recipe rec) {
		// this is vegan
		if (isVegan(this)) {
			// rec is vegan, value is equal for both
			if (isVegan(rec)) {
				return 0;
			}

			// rec is not vegan, this' value is lower.
			else {
				return -1;
			}
		}
		// this is veggie
		else if (!this.hasMeat()) {
			// rec is vegan, this' value must be higher
			if (isVegan(rec)) {
				return 1;
			}

			// rec is veggie, value is equal for both
			else if (!rec.hasMeat()) {
				return 0;
			}

			// rec has meat, this' value is lower.
			else {
				return -1;
			}
		}

		// this has meat
		else {
			// rec is vegan, this' value is higher
			if (isVegan(rec)) {
				return 1;
			}

			// rec is veggie, this' value is higher
			else if (!rec.hasMeat()) {
				return 1;
			}

			// both have meat, value is the same
			else {
				return 0;
			}
		}

	}

}
