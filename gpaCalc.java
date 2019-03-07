import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

/*Alex Wassel*/


/**Add courses or add 15 blank credit hours to fill in the screen space. In office hours, we decided that I could
 * assume that the user will not enter more than 105 credits. Also assuming common sense that user will add "15 Blank
 * Credit Hours" before entering a Target GPA and clicking "Submit Target GPA" because that is based on the assignment
 * and my assumption. Follow instructions**/

/**
 * source for font:
 * https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
 **/

public class HW5GPA {

	/**
	 * Swing components here as fields - setting up JLabels, JTextFields, JButtons
	 * here
	 **/
	private JFrame frame;
	private JTextField credits;
	private JTextField grade;
	private JTextField course;
	private JLabel creditLabel;
	private JLabel gradeLabel;
	private JLabel courseLabel;
	private JComboBox gradeBox;
	private JLabel titleLabel;
	private JButton submitBtn;
	private JLabel gpaView;
	private ArrayList<Double> gpaConversion = new ArrayList<Double>();
	private ArrayList<Double> gpaList = new ArrayList<Double>();
	private ArrayList<String> stringList = new ArrayList<String>();
	private JLabel gpaWindow;
	private JList totalList;
	private double gpa = 0.0;
	private ArrayList<Integer> creditList = new ArrayList<Integer>();
	private JButton removeAllCourses;
	private JButton removeCourse;
	private JButton blankBtn;
	private JLabel instructions;
	private JLabel instructions2;
	private JLabel instructions3;
	private JLabel instructions4;
	private JLabel targetGpaLabel;
	private JTextField targetGpaTextField;
	private JButton targetGpaBtn;
	private JLabel recommendationGpa;
	private double gpaTargetNum;

	/**
	 * main() method that prints a sentence if app is working, using invokeLater
	 **/
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				HW5GPA theApp = new HW5GPA();
				System.out.println("The application has launched!");
			}
		});
		System.out.println("main() method exiting!"); // to Console

	}

	/** constructor() that sets initialize() method to be later called back **/
	public HW5GPA() {
		initialize();
	}

	/**
	 * initialize() method that initializes all components, calling initialize() in
	 * the constructor
	 **/
	private void initialize() {

		/**
		 * ArrayList that has the GPA values of each grade of gradeOptions method in
		 * order
		 **/
		gpaConversion = new ArrayList<Double>();
		gpaConversion.add(4.0);
		gpaConversion.add(4.0);
		gpaConversion.add(3.7);
		gpaConversion.add(3.3);
		gpaConversion.add(3.0);
		gpaConversion.add(2.7);
		gpaConversion.add(2.3);
		gpaConversion.add(2.0);
		gpaConversion.add(1.7);
		gpaConversion.add(1.3);
		gpaConversion.add(1.0);
		gpaConversion.add(0.7);
		gpaConversion.add(0.0);

		/** Configuring the JFrame **/
		frame = new JFrame();
		frame.setTitle("GPA Calculator");
		int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		frame.setSize(width, height);
		// Assuming TA has a normal-sized laptop, still works on all screens though
		// because used Toolkit.getDefaultToolkit().getScreenSize().getWidth(); to ge
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // always protocol
		frame.setLayout(new FlowLayout());

		/**
		 * Making JPanels for organization and aesthetics, as well as BorderLayout for
		 * specifiying location of these Panels and components added to the panels.
		 * Panels added to the frame.
		 **/

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLACK);
		frame.add(mainPanel);

		JPanel mainPanel2 = new JPanel();
		// mainPanel2.setBackground(Color.BLACK);
		frame.add(mainPanel2);

		JPanel jp = new JPanel();
		jp.setBackground(Color.GREEN);
		// jp.setLayout(new BorderLayout());
		mainPanel.add(jp, BorderLayout.NORTH);

		JPanel jp1 = new JPanel();
		jp1.setBackground(Color.WHITE);
		jp1.setLayout(new BorderLayout());
		mainPanel2.add(jp1, BorderLayout.SOUTH);

		/** Welcome Title JLabel- title of my app with specific font **/
		titleLabel = new JLabel("Welcome to the GPA calculator!");
		titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		jp.add(titleLabel);
		// frame.add(titleLabel);

		/**
		 * JLabel for instructions - I gave instructions for aethetics and for better
		 * understanding of the app, easier to use
		 **/
		instructions = new JLabel(
				"<html> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp; Instructions:  <html> ");
		instructions.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		jp1.add(instructions, BorderLayout.NORTH);
		// frame.add(instructions);

		/**
		 * JLabel for instructions2 - specific instrctuions that also say that entering
		 * credits is mandatory and grade and course name are optional
		 **/
		instructions2 = new JLabel(
				"<html> 1. Enter the number of credits corresponding to the appropriate course (mandatory) <br> 2. Select your grade in that course (optional) <br> 3. Enter the name of that course (optional) </html>");
		instructions2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		jp1.add(instructions2, BorderLayout.SOUTH);
		// frame.add(instructions2);

		/** JLabel to label the first input text-field **/
		creditLabel = new JLabel("Enter number of credits: ");
		frame.add(creditLabel);

		/** JTextField for first input of above **/
		credits = new JTextField(5);
		frame.add(credits);

		/** JLabel to label the second input text-field **/
		gradeLabel = new JLabel("Enter your letter grade: ");
		frame.add(gradeLabel);

		/** JComboBox for second input of above **/
		String[] gradeOptions = { " ", "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C+", "D+", "D", "D-", "F" };
		gradeBox = new JComboBox(gradeOptions);
		frame.add(gradeBox);

		/** JLabel to label the third input text-field **/
		courseLabel = new JLabel("Enter your course name: ");
		frame.add(courseLabel);

		/** JTextField for third input of above **/
		course = new JTextField(30);
		frame.add(course);

		/**
		 * JButton for Submitting a course - added a class HandleSubmitPressed() for
		 * actions of the button
		 **/
		submitBtn = new JButton("Submit Course");
		frame.add(submitBtn);
		submitBtn.addActionListener(new HandleSubmitPressed());

		/** JLabel that shows current GPA (gpaView) **/
		gpaView = new JLabel("Current GPA: -");
		frame.add(gpaView);

		/**
		 * JList containing ArrayList stringList with gpa, course, credits - neat setup
		 * and clean borders with JList
		 **/
		totalList = new JList();
		stringList.add("Number of Credits            GPA            Class Name");
		frame.add(totalList);
		totalList.setListData(stringList.toArray());

		/** JButton for removing all courses at once **/
		removeAllCourses = new JButton("Remove All Courses");
		frame.add(removeAllCourses);

		/**
		 * ActionListener for when "Remove All Courses" button is pressed - clears some
		 * lists because removes all courses
		 **/
		removeAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("removeAllCourses button has been pressed!");
				gpa = 0;
				gpaList.clear();
				creditList.clear();
				stringList.clear();
				stringList.add("Number of Credits            GPA            Class Name");
				totalList.setListData(stringList.toArray());
				gpaView.setText("GPA: 0.00");

				double currentCredits = 0.00;
				double emptyCredits = 0.00;
				for (int i = 0; i < gpaList.size(); i++) {
					if (gpaList.get(i) == null) {
						emptyCredits += 3;
					} else {
						currentCredits += creditList.get(i);
					}
				}
				gpaTargetNum = Double.parseDouble(targetGpaTextField.getText());
				double courseGpa = (gpaTargetNum * (currentCredits + emptyCredits) - gpa * currentCredits)
						/ emptyCredits;
				DecimalFormat df = new DecimalFormat("#.###");
				if (courseGpa > 4) {
					recommendationGpa
							.setText("Average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa)
									+ ". This is greater than 4.0 so try adding more credit hours and recalculate.");
				} else if (courseGpa < 2) {
					recommendationGpa
							.setText("Average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa)
									+ ". This is less than 2.0 so try taking fewer credit hours if you wish.");
				} else {
					recommendationGpa.setText(
							"Recommendation: average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa));
				}
			}
		});

		/**
		 * JButton for removing selected course - neat button correctly placed on the
		 * frame that removes specific course
		 **/
		removeCourse = new JButton("Remove Selected Course");
		frame.add(removeCourse);
		/**
		 * ActionListener for when "Remove Selected Course" button is pressed - does the
		 * actions below
		 **/
		removeCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("removeCourse button has been pressed!");
				gpaList.remove(totalList.getSelectedIndex() - 1);
				creditList.remove(totalList.getSelectedIndex() - 1);
				stringList.remove(totalList.getSelectedIndex());
				totalList.setListData(stringList.toArray());

				// GPA Formula (math involved)
				double sum1 = 0;
				double sum2 = 0;
				for (int i = 0; i < gpaList.size(); i++) {
					if (gpaList.get(i) == null) {
						continue;
					}
					sum1 += gpaList.get(i) * creditList.get(i);
					sum2 += creditList.get(i);
				}
				gpa = sum1 / sum2;
				DecimalFormat dec = new DecimalFormat("#.##");
				gpaView.setText("GPA: " + dec.format(gpa));

				double currentCredits = 0.00;
				double emptyCredits = 0.00;
				for (int i = 0; i < gpaList.size(); i++) {
					if (gpaList.get(i) == null) {
						emptyCredits += 3;
					} else {
						currentCredits += creditList.get(i);
					}
				}
				gpaTargetNum = Double.parseDouble(targetGpaTextField.getText());
				double courseGpa = (gpaTargetNum * (currentCredits + emptyCredits) - gpa * currentCredits)
						/ emptyCredits;
				DecimalFormat df = new DecimalFormat("#.###");
				if (courseGpa > 4) {
					recommendationGpa
							.setText("Average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa)
									+ ". This is greater than 4.0 so try adding more credit hours and recalculate.");
				} else if (courseGpa < 2) {
					recommendationGpa
							.setText("Average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa)
									+ ". This is less than 2.0 so try taking fewer credit hours if you wish.");
				} else {
					recommendationGpa.setText(
							"Recommendation: average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa));
				}
			}
		});

		/**
		 * JButton for adding blank lines. Assume a new course is 3 credit hours because
		 * it is the most common amount of credits per course, so every time button is
		 * clicked, 5 3-credit classes are added (another assumption). Chose this way
		 * because most popular, relatable, and clearer.
		 **/
		blankBtn = new JButton("Add 15 Blank Credit Hours");
		frame.add(blankBtn);
		/** ActionListener for when "blankBtn" button is pressed **/
		blankBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("blankBtn button has been pressed!");
				for (int i = 0; i < 5; i++) {
					gpaList.add(null);
					creditList.add(3);
					stringList.add("3                                     " + null);
				}
				totalList.setListData(stringList.toArray());

				double currentCredits = 0.00;
				double emptyCredits = 0.00;
				for (int i = 0; i < gpaList.size(); i++) {
					if (gpaList.get(i) == null) {
						emptyCredits += 3;
					} else {
						currentCredits += creditList.get(i);
					}
				}
				gpaTargetNum = Double.parseDouble(targetGpaTextField.getText());
				double courseGpa = (gpaTargetNum * (currentCredits + emptyCredits) - gpa * currentCredits)
						/ emptyCredits;
				DecimalFormat df = new DecimalFormat("#.###");
				if (courseGpa > 4) {
					recommendationGpa
							.setText("Average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa)
									+ ". This is greater than 4.0 so try adding more credit hours and recalculate.");
				} else if (courseGpa < 2) {
					recommendationGpa
							.setText("Average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa)
									+ ". This is less than 2.0 so try taking fewer credit hours if you wish.");
				} else {
					recommendationGpa.setText(
							"Recommendation: average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa));
				}
			}
		});

		/** JLabel for targetGpaLabel **/
		targetGpaLabel = new JLabel("Target GPA: ");
		frame.add(targetGpaLabel);

		/** JTextField for targetGpaTextField **/
		targetGpaTextField = new JTextField(5);
		frame.add(targetGpaTextField);

		/** Jlabel for Recommendation **/
		recommendationGpa = new JLabel("Recommendation: ");
		frame.add(recommendationGpa);

		/** JButton for targetGpaBtn **/
		targetGpaBtn = new JButton("Submit Target GPA");
		frame.add(targetGpaBtn);
		/**
		 * ActionListener for when target button is pressed - does the actions below
		 * when button is clicked, in a clean way and understandable (math involved with
		 * formula shown)
		 **/
		targetGpaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("targetGpaBtn button has been pressed!");
				double currentCredits = 0.00;
				double emptyCredits = 0.00;
				for (int i = 0; i < gpaList.size(); i++) {
					if (gpaList.get(i) == null) {
						emptyCredits += 3;
					} else {
						currentCredits += creditList.get(i);
					}
				}
				gpaTargetNum = Double.parseDouble(targetGpaTextField.getText());
				double courseGpa = (gpaTargetNum * (currentCredits + emptyCredits) - gpa * currentCredits)
						/ emptyCredits;
				DecimalFormat df = new DecimalFormat("#.###");
				if (courseGpa > 4) {
					recommendationGpa
							.setText("Average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa)
									+ ". This is greater than 4.0 so try adding more credit hours and recalculate.");
				} else if (courseGpa < 2) {
					recommendationGpa
							.setText("Average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa)
									+ ". This is less than 2.0 so try taking fewer credit hours if you wish.");
				} else {
					recommendationGpa.setText(
							"Recommendation: average required GPA needed in the rest of your classes to get target GPA: "
									+ df.format(courseGpa));
				}
			}
		});

		frame.setVisible(true); // always protocol to actually show frame

	}

	/**
	 * ActionListener for when Submit Class button is pressed - does the actions
	 * shown below in a clear way when button is pressed, as needed. Same gpa
	 * formula used for this button so that it updates every time you press this
	 * button.
	 **/
	class HandleSubmitPressed implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Submit button has been pressed!");
			// gpaList.add(gpaConversion.get(gradeBox.getSelectedIndex() - 1));
			creditList.add(Integer.parseInt(credits.getText()));

			if (gradeBox.getSelectedIndex() == 0) {
				gpaList.add(null);
			} else {
				gpaList.add(gpaConversion.get(gradeBox.getSelectedIndex() - 1));
			}

			// for info on totalList
			stringList.add(credits.getText() + "                                     " + gpaList.get(gpaList.size() - 1)
					+ "             " + course.getText()); // the last index you clicked
			totalList.setListData(stringList.toArray()); // setListData only takes Arrays not ALs

			// creditList.add(Integer.parseInt(credits.getText()));

			/** GPA Formula **/
			double sum1 = 0;
			double sum2 = 0;
			for (int i = 0; i < gpaList.size(); i++) {
				if (gpaList.get(i) == null) {
					continue;
				}
				sum1 += gpaList.get(i) * creditList.get(i);
				sum2 += creditList.get(i);
			}
			gpa = sum1 / sum2;
			DecimalFormat dec = new DecimalFormat("#.##");
			gpaView.setText("Current GPA: " + dec.format(gpa));

			double currentCredits = 0.00;
			double emptyCredits = 0.00;
			for (int i = 0; i < gpaList.size(); i++) {
				if (gpaList.get(i) == null) {
					emptyCredits += 3;
				} else {
					currentCredits += creditList.get(i);
				}
			}
			gpaTargetNum = Double.parseDouble(targetGpaTextField.getText());
			double courseGpa = (gpaTargetNum * (currentCredits + emptyCredits) - gpa * currentCredits) / emptyCredits;
			DecimalFormat df = new DecimalFormat("#.###");
			if (courseGpa > 4) {
				recommendationGpa.setText("Average required GPA needed in the rest of your classes to get target GPA: "
						+ df.format(courseGpa)
						+ ". This is greater than 4.0 so try adding more credit hours and recalculate.");
			} else if (courseGpa < 2) {
				recommendationGpa.setText("Average required GPA needed in the rest of your classes to get target GPA: "
						+ df.format(courseGpa)
						+ ". This is less than 2.0 so try taking fewer credit hours if you wish.");
			} else {
				recommendationGpa.setText(
						"Recommendation: average required GPA needed in the rest of your classes to get target GPA: "
								+ df.format(courseGpa));
			}

		}

	}
}
