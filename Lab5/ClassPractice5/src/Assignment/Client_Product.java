package Assignment;

public class Client_Product {
    String Gender;
    String City_Dwellers;
    String productTypes = "No Product";
    int age;

    public void setInput(String Gender, String City_Dwellers, int age) {
        this.Gender = Gender;
        this.City_Dwellers = City_Dwellers;
        this.age = age;
    }

    public String assignProduct() {
        if (Gender.equals("Female")) {
            if (City_Dwellers.equals("Yes")) {  
                // BUG: The decision table test sample uses "City_Dwellers" as input,
                // but the code expects "Yes". This inconsistency may cause test failures.
                if (age < 35) {
                    productTypes = "W X and Y";
                }
                // BUG: Using (age >= 35) || (age <= 65) is incorrect.
                // The intended range (35 to 65) requires an AND (&&) operator.
                if ((age >= 35) || (age <= 65)) {
                    productTypes = "X and Y";
                }
                if (age > 65) {
                    productTypes = "Only Y";
                }
            } else if (City_Dwellers.contentEquals("No")) {
                if (age < 35) {
                    productTypes = "W and X";
                }
                if ((age >= 35) && (age <= 65)) {
                    productTypes = "Only X";
                }
            }
        } else if (Gender.contentEquals("Male")) {
            if (City_Dwellers.contentEquals("Yes")) {
                // For male city dwellers, all age groups are assigned product X.
                if ((age < 35) || ((age >= 35) && (age <= 65)) || (age > 65)) {
                    productTypes = "Only X";
                }
            } else if (City_Dwellers.contentEquals("No")) {
                // BUG: The condition (age < 35) && (age > 65) is impossible.
                if ((age < 35) && (age > 65)) {
                    productTypes = "Only X";
                }
                // BUG: According to the specification, middle-aged (35–65) male non-city dwellers
                // should be assigned product Z only. Here, "W and Z" is returned.
                if ((age >= 35) && (age <= 65)) {
                    productTypes = "W and Z";
                }
            }
        }
        return productTypes;
    }
}
