package Lab3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NextDateTest {

    @Test
    void testValidDateNotLastDayOfMonth() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 15, 3);
        String result = nextDate.next_date();
        assertEquals("Next Date is :16-3-2024", result);
    }

    @Test
    void testValidDateEndOfMonth() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 31, 1);
        String result = nextDate.next_date();
        assertEquals("Next Date is :1-2-2024", result);
    }

    @Test
    void testValidDateEndOfYear() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 31, 12);
        String result = nextDate.next_date();
        assertEquals("Next Date is :1-1-2025", result);
    }

    @Test
    void testLeapYearFebruary() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 28, 2);
        String result = nextDate.next_date();
        assertEquals("Next Date is :29-2-2024", result);
    }

    @Test
    void testNonLeapYearFebruary() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2023, 28, 2);
        String result = nextDate.next_date();
        assertEquals("Next Date is :1-3-2023", result);
    }

    @Test
    void testInvalidDayOutOfRange() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 32, 5);
        String result = nextDate.next_date();
        assertEquals("Value of day, not in the range 1...31", result);
    }

    @Test
    void testInvalidMonthOutOfRange() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 15, 13);
        String result = nextDate.next_date();
        assertEquals("value of month, not in the range 1....12", result);
    }

    @Test
    void testInvalidYearOutOfRange() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(1799, 15, 5);
        String result = nextDate.next_date();
        assertEquals("value of year, not in the range 1800.......2025", result);
    }

    @Test
    void testEndOfFebruaryLeapYear() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 29, 2);
        String result = nextDate.next_date();
        assertEquals("Next Date is :1-3-2024", result);
    }

    @Test
    void testEndOfFebruaryNonLeapYear() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2023, 28, 2);
        String result = nextDate.next_date();
        assertEquals("Next Date is :1-3-2023", result);
    }

    @Test
    void testEndOfDecember() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2025, 31, 12);
        String result = nextDate.next_date();
        assertEquals("the next day is out of boundary value of year", result);
    }

    @Test
    void testValidDateEndOfThirtyDayMonth() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 30, 4); // Tháng 4 có 30 ngày
        String result = nextDate.next_date();
        assertEquals("Next Date is :1-5-2024", result);
    }

    @Test
    void testInvalidDayForThirtyDayMonth() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 31, 4); // Tháng 4 chỉ có 30 ngày
        String result = nextDate.next_date();
        assertEquals("value of day, not in the range day<=30", result);
    }

    @Test
    void testFirstDayOfLeapYear() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 1, 1); // Năm nhuận
        String result = nextDate.next_date();
        assertEquals("Next Date is :2-1-2024", result);
    }

    @Test
    void testInvalidDateFebruaryNonLeapYear() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2023, 29, 2); // Tháng 2 năm không nhuận
        String result = nextDate.next_date();
        assertEquals("invalid date input for not a leap year", result);
    }

    @Test
    void testInvalidDayBelowRange() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 0, 5);
        String result = nextDate.next_date();
        assertEquals("Value of day, not in the range 1...31", result);
    }

    @Test
    void testNextDayInDecember() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 10, 12);
        String result = nextDate.next_date();
        assertEquals("Next Date is :11-12-2024", result);
    }

    @Test
    void testInvalidDateInputForLeapYear() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 30, 2);
        String result = nextDate.next_date();
        assertEquals("invalid date input for leap year", result);
    }

    @Test
    void testNextDateInNovember() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 29, 11);
        String result = nextDate.next_date();
        assertEquals("Next Date is :30-11-2024", result);
    }

    @Test
    void testNextDateOfFebruary() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 10, 2);
        String result = nextDate.next_date();
        assertEquals("Next Date is :11-2-2024", result);
    }

    @Test
    void testInvalidDateOfJune() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 31, 6);
        String result = nextDate.next_date();
        assertEquals("value of day, not in the range day<=30", result);
    }

    @Test
    void testInvalidDateOfSeptember() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 31, 9);
        String result = nextDate.next_date();
        assertEquals("value of day, not in the range day<=30", result);
    }

    @Test
    void testInvalidDateOfNovember() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 31, 11);
        String result = nextDate.next_date();
        assertEquals("value of day, not in the range day<=30", result);
    }

    @Test
    void testYearDivisibleBy4Not100() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 15, 2); // Năm chia hết cho 4 nhưng không chia hết cho 100
        String result = nextDate.next_date();
        assertEquals("Next Date is :16-2-2024", result);
    }

    @Test
    void testYearDivisibleBy400() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2000, 15, 2); // Năm chia hết cho 400
        String result = nextDate.next_date();
        assertEquals("Next Date is :16-2-2000", result);
    }

    @Test
    void testYearDivisibleBy100Not400() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(1900, 29, 2); // Năm chia hết cho 100 nhưng không chia hết cho 400
        String result = nextDate.next_date();
        assertEquals("invalid date input for not a leap year", result);
    }

    @Test
    void testInvalidMonthOver12() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 13, 13);
        String result = nextDate.next_date();
        assertEquals("value of month, not in the range 1....12", result);
    }

    @Test
    void testInvalidMonthUnder1() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 13, 0);
        String result = nextDate.next_date();
        assertEquals("value of month, not in the range 1....12", result);
    }

    @Test
    void testYearOver2025() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2026, 13, 12);
        String result = nextDate.next_date();
        assertEquals("value of year, not in the range 1800.......2025", result);
    }

    @Test
    void testYearUnder1800() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(1600, 13, 12);
        String result = nextDate.next_date();
        assertEquals("value of year, not in the range 1800.......2025", result);
    }

    @Test
    void testMarchFirst() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 1, 3);
        String result = nextDate.next_date();
        assertEquals("Next Date is :2-3-2024", result);
    }

    @Test
    void testSwitchCaseWithJune() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 30, 6);
        String result = nextDate.next_date();
        assertEquals("Next Date is :1-7-2024", result);
    }

    @Test
    void testSwitchCaseWithNovember() {
        NextDate nextDate = new NextDate();
        nextDate.setYearmonthdate(2024, 30, 11);
        String result = nextDate.next_date();
        assertEquals("Next Date is :1-12-2024", result);
    }
}