package Q2;

public class ScholarshipEligibility {

    public static String calculateScholarshipEligibility(double gpa, int extracurricularActivities,
            int volunteerHours) {
        if (gpa < 0.0 || gpa > 4.0) {
            return "Invalid";
        }
        if (extracurricularActivities < 0 || extracurricularActivities > 10) {
            return "Invalid";
        }
        if (volunteerHours < 0 || volunteerHours > 300) {
            return "Invalid";
        }
        if (gpa >= 3.5 && extracurricularActivities >= 5 && volunteerHours >= 100) {
            return "Full scholarship";
        } else if (gpa >= 3.0 && extracurricularActivities >= 3 && volunteerHours >= 50) {
            return "Partial scholarship";
        } else {
            return "Not eligible";
        }
    }
}
