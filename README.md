# GPA Calculator and Planner Using Swing

## Overview
GUI that calculates GPA based on previously taken courses, and courses with anticipated grades. This product also gives the user insight on how to meet their target GPA goals by allowing users to add or take away future credit hours sufficient to meet those goals.

Main Component:
Courses and Summary

### Courses:
User can input previously taken, current, and anticipated courses.
Input includes credit hours, optional grade, and optional course name.

Visual list of entered courses.
User is able to remove a single course and remove all the courses.
User has an option to quickly add 15 blank credit hours.
Course name and grade is optional, so the user can just enter blocks of unknown courses (useful for future courses).
A refreshed course page resets the GPA.
 
### Summary
Shows current GPA based on courses entered with grades.
User can enter a total Target GPA for all credit hours entered, regardless of whether they have class names or grades.
Calculator displays the total Required GPA on the blank credit hours in order to reach the target GPA from the current GPA.
Gives a warning if the required GPA is greater than 4.0, and suggests the user that they could try adding more credit hours and recalculating.
If the Required GPA is less than 2.0, it suggests that the user could take fewer credit hours if they wish.

### Aesthetics
Display avoids a fixed width, anticipating that thte software could be run on many types of machines. Thus, employed a dynamic layout.
