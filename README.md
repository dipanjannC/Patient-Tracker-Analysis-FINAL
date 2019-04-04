# Patient-Tracker-Analysis-FINAL

PATIENT TRACKER ANALYSIS

GROUP MEMBERS ARE:

PRATIK PRITAM			761513
PRIYASHA DUVEDI			761556
VIGNESH G			760876
SHASHI BHUSHAN SINGH		761518
DIPANJAN CHOWDHARY		761334



In this project I have implemented the concepts of Java-Core, JSP, Hibernate, HTML, CSS, Bootstrap and we
have followed the Spring MVC Architecture for the creation of this entire project.



	There are seven different modules in this entire program:


	->Admin login and registration.

	->Clerk registration, fetching and updating.

	->Doctor registration, fetching and updating.

	->Patient registration, fetching and updating.

	->Medicine registration, fetching and updating.

	->Prescription registration, fetching and updating.

	->Bill fetching records and creation of final receipt for the customer and 
	  updating the status in the prescription module as well.



	Admin Login and Registration

		->As soon as the project gets started they are guided to this page.

		->If the user is a new user, they can click on Register after which the user will be 
		  guided to a form to fill in the necessary details to register themselves for the system.

		->If the user is an existing user, they can enter their credentials and click on Login.

		->After proper authentication the user will be guided to the Home Page where they will 
	          have the chance to explore on the other six modules.



	Home Page


		->After reaching the Home Page we would be able to see a tab on the left with various options.

		->Clerk Tab will guide to Clerk page initially fetching all records.

		->Doctor Tab will guide to Doctor page initially fetching all records.

		->Patient Tab will guide to Patient page initially fetching all records.

		->Medicine Tab will guide to Medicine page initially fetching all records. 

		->Prescription Tab will guide to Prescription page initially fetching all records.

		->Bill Tab will guide to Bill page initially fetching all records.

		->Clicking on the logo of the webpage, i.e., ‘PatientX’ will always lead back to the
		  same Home Page no matter which tab we are using currently.

		->Clicking on the Logout button will lead us back to the same Login/Registration page for the Admin.

	        ->On clicking the Sidebar Navigator icon the navigation bar gets hidden and only the main content of the page is visible.

		->Some of the tabs are yet to be worked on in the navigation bar like Home button, Download Code, About Us, Article, Services,
		  Appointments, Disabled.



	Clerk Registration, Fetching and Updating:


		->As soon as the Clerk Tab is clicked it leads us to the Clerk Page initially fetching all present records in the Table.

		->The search bar on the top helps us to find any record or set of records with similar data.

		->Clicking on the ‘+’ button on the top will lead to a form which will ask for basic details.

		->In the form if we click on the Add button the details get added as a record into the table and a message is displayed along with their ID’s.

		->In the form if we click on the Clear button the Form gets cleared and the user needs to enter the details again.

		->After adding it goes back to fetching all the records.

		->If the ‘Edit’ button is clicked, the complete record for the clerk is shown with Id as read-only as it is auto-generated.

		->After the Updating the complete table with all records of clerk are shown.

		->From the main set of records if the user clicks on the ID of the Clerk the complete details are shown for the same.





	Doctor Registration, Fetching and Updating:


		->As soon as the Doctor Tab is clicked it leads us to the Doctor Page initially fetching all present records in the Table.

		->The search bar on the top helps us to find any record or set of records with similar data.

		->Clicking on the ‘+’ button on the top will lead to a form which will ask for basic details.

		->In the form if we click on the Add button the details get added as a record into the table and a message is displayed along with their ID’s.

		->In the form if we click on the Clear button the Form gets cleared and the user needs to enter the details again.

		->After adding it goes back to fetching all the records.

		->If the ‘Edit’ button is clicked, the complete record for the Doctor is shown with Id as read-only as it is auto-generated.

		->After the Updating the complete table with all records of Doctor are shown.

		->From the main set of records if the user clicks on the ID of the Doctor the complete details are shown for the same.






	Patient Registration, Fetching and Updating:


		->As soon as the Patient Tab is clicked it leads us to the Patient Page initially fetching all present records in the Table.

		->The search bar on the top helps us to find any record or set of records with similar data.

		->Clicking on the ‘+’ button on the top will lead to a form which will ask for basic details.

		->In the form if we click on the Add button the details get added as a record into the table and a message is displayed along with their ID’s.

		->In the form if we click on the Clear button the Form gets cleared and the user needs to enter the details again.

		->After adding it goes back to fetching all the records.

		->If the ‘Edit’ button is clicked, the complete record for the Patient is shown with Id as read-only as it is auto-generated.

		->After the Updating the complete table with all records of Patient are shown.

		->From the main set of records if the user clicks on the ID of the Patient the complete details are shown for the same.






	Medicine Registration, Fetching and Updating:

		->As soon as the Medicine Tab is clicked it leads us to the Medicine Page initially fetching all present records in the Table.

		->The search bar on the top helps us to find any record or set of records with similar data.

		->Clicking on the ‘+’ button on the top will lead to a form which will ask for basic details.

		->In the form if we click on the Add button the details get added as a record into the table and a message is displayed along with their ID’s.

		->In the form if we click on the Clear button the Form gets cleared and the user needs to enter the details again.

		->After adding it goes back to fetching all the records.

		->If the ‘Edit’ button is clicked, the complete record for the Medicine is shown with Id as read-only as it is auto-generated.

		->After the Updating the complete table with all records of Medicine are shown.

		->From the main set of records if the user clicks on the ID of the Medicine the complete details are shown for the same.






	Prescription Registration, Fetching and Updating:


		->As soon as the Prescription Tab is clicked it leads us to the Prescription Page initially fetching all present records in the Table.

		->It is fetching PatientID from the Patient records and DoctorID from the Doctor Records and MedicineID’s from Medicine Records.

		->The search bar on the top helps us to find any record or set of records with similar data.

		->Clicking on the ‘+’ button on the top will lead to a form which will ask for basic details.

		->In the form if we click on the Add button the details get added as a record into the table and a message is displayed along with their ID’s.

		->In the form if we click on the Clear button the Form gets cleared and the user needs to enter the details again.

		->After adding it goes back to fetching all the records.

		->If the ‘Edit’ button is clicked, the complete record for the Prescription is shown with Id as read-only as it is auto-generated.

		->After the Updating the complete table with all records of Prescription are shown.

		->From the main set of records if the user clicks on the ID of the Prescription, the complete details are shown for the same.







	Bill Fetching and Creation:


		->As soon as the Bill Tab is clicked it leads us to the Bill Page initially fetching all present records in the Table.

		->The search bar on the top helps us to find any record or set of records with similar data.

		->The generate bill icon on the right most column of the bill table prints “Bill”.
