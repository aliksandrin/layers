There are three modules:
- UI:
	receive a string in arguments and sends it ro Service
- Service:
	validates received string, if it is valid to be a date. Makes Date instance and sends it to DAO
- DAO:
	receives a Date from Service and finds out what is tha day of the week for this date

NOTE:
Also I used slf4j with log4j. It writes log in System.out and file auto-created near our .jar ot project.

RELEASED:
- Unit test for all classes
- Integration Tests
- Test Categories
- Maven profiles for on/off tests

FIX:
- lo4j.properties now log4j.xml
- usage <dependency-management>
