Feature: Web Form Automation Testing
  Mục đích: Kiểm tra các chức năng của web form
  Người dùng: Tester

  Scenario: Hoàn thành quy trình điền thông tin và gửi form
    # I. Mở trang web form
    Given I navigate to "https://www.selenium.dev/selenium/web/web-form.html"
    
    # II. Điền các trường thông tin
    When I fill in "Text Input" with "AutomationTestUser"
    And I fill in "Password" with "Pass@123"
    And I fill in "Text Area" with "Đây là bài kiểm tra tự động."
    
    # III. Nhấn vào link "Return to index"
    And I click on the "Return to index" link
    
    # IV. Kiểm tra tiêu đề của trang index
    Then the page title should be "Index of Available Pages"
    
    # V. Quay trở lại trang web form
    When I navigate back to "https://www.selenium.dev/selenium/web/web-form.html"
    
    # VI. Chọn một option trong DropDown menu
    And I select "Two" from the "DropDown" menu
    
    # VII. Kiểm tra checkbox và radio button đã được chọn
    Then the "Checked Check Box" should be selected
    And the "Checked Radio Box" should be selected
    
    # VIII. Xác định default checkbox bằng Relative Locator
    When I locate the "Default Checkbox" using a relative locator
    
    # IX. Thay đổi màu trên Color Picker
    And I change the "Color Picker" to "#ff5733"
    
    # X. Đặt ngày cho Date Picker
    And I set the "Date Picker" to "2025-03-01"
    
    # XI. Nhấn nút Submit
    And I click the "Submit" button
    
    # XII. Kiểm tra thông báo sau khi submit
    Then I should see the message "Received!" on the submission page
