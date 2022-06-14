# LoginSystem
Login system using only Java

Simple login system that contains the following:
-Simple UI
-Login & Registration buttons
-Simple User validation algorythm

UI:
FieldUserName - Input username text
FieldPassword - Input password text

*FIELD REGISTRATION*
User inputs userdata
Class Class_Name checks the file in FileSystem(FS) whether the Username is already there
if(true)
{throws user already exist}

If User doesn't exist class Class_Name should write write given credentials into the file with colon (:) delimeted

*FIELD LOGIN*
User inputs userdata
Class Class_Name reads the file in the file system and checks if user in the list
-if user not found throws {username or password is incorrect}
-if user found then check the password for this user
-if password doesn't match throws {username or password is incorrect}
-if password matches message {You have been logged in}



Class description

    - *LoginPage implements ActionListener*
      this class contain login frame implementation and it implements ActionListener to listen the buttons
      
    - *ReadFile*
      this class reads the file from the file system and returns a HashMap as a result
      
    - *WriteFile*
      this class writes file "userCredentials.txt" delimited by the colon (:). Returns nothing (void)
      
    - *Encrypt*
      encrypt user password in HASH value. Returns String
      
    - *UserExistence*
      reads the file from the FS and search whether passed parameter (HashMap Key)exist in the file
      
    - *ValidateUser*
       returns boolean. reads file and:
                          - Check whether username exist
                          - Check whether username (key) has the provided password
    - *Registration*
       Writes provided user data into file in FS
