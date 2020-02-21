program main;

uses sysutils;


procedure readTasks(filename:string);

VAR
   usersFile  : TEXT;
   line            : STRING;
   code          : STRING;
   param1,param2, request:string;
 

BEGIN

   {proceso de lectura del fichero filename }

   {$i-} { Deactivate checkout of input/output errors}
   Assign(usersFile, filename);
   Reset(usersFile);
   {$i+} { Activate checkout of input/output errors}
   IF (IoResult <> 0) THEN BEGIN
      writeln('**** Error reading '+filename);
      halt(1)
   END;


   WHILE NOT EOF(usersFile) DO
   BEGIN
      { Read a line in the file and save it in different variables}
      ReadLn(usersFile, line);
      code := trim(copy(line,1,2));
      request:= line[4];
      param1 := trim(copy(line,5,10)); { trim removes blank spaces of the string}
                                         { copy(s, i, j) copies j characters of string s }
                                       { from position i }
      param2 := trim(copy(line,15,10));

	  {CHANGE writeln for the corresponding operation}
	  writeln(code, ' ', request, ': ', param1, ' ',param2);
    END;

   Close(usersFile);

END;


{Main program}

BEGIN
   
    if (paramCount>0) then
        readTasks(ParamStr(1))
    else
        readTasks('create.txt');

END.
