There are three modules:
- UI
		receive a string in arguments and sends it ro Service
- Service
		validates received string, if it is valid to be a date. Makes Date instance and sends it to DAO
- DAO
		receives a Date from Service and finds out what is tha day of the week for this date


Also I used slf4j with log4j. It writes log in System.out and file near our .jar.

KNOWN ISSUES:
- If you try to run .jar file from bash, there will be an errors about .properties file before result. But it works.
	I'd like to about it during our friday lesson.
