program main;
{Titulo: Programming II Labs
Subtitulo: Practica 2
Autor 1: Oscar Perez Sanchez  Login 1: oscar.perez.sanchez
Autor 2: David Bermudez Lopez  Login 2: david.bermudez
Grupo: 2.1
Fecha: 03/05/2019}
uses sysutils, SharedTypes, RequestQueue, CenterList, PartyList, Manager;

PROCEDURE Create(cn:string; vt:string; var M:tManager); 
var aux:integer;
begin 
    val(vt, aux);
	if insertCenter(cn,aux,M) = TRUE then  
	   writeln('*Create: center ', cn,' totalvoters ', vt)
	else writeln('+Error: Create not possible');
end;

PROCEDURE New(cn:string; pt:string; var M:tManager);
begin
  if insertPartyInCenter(cn,pt,M)=TRUE then writeln('* New: center ', cn,' party ',pt)
  else writeln('+ Error: New not possible');
end;

PROCEDURE Remove(var M:tManager);
begin
  if deleteCenters(M)=0 then writeln('*Remove: no centers removed')
  else deleteCenters(M);
end;

PROCEDURE Vote(cn:string; pt:string; var M:tManager);
begin
  if voteInCenter(cn,pt,M)=TRUE then 
    writeln('* Vote: center ', cn,' party ',pt)
  else writeln('+ Error: Vote not possible. Party ',pt,' not found in center ',cn,'. NULLVOTE');
end;

PROCEDURE Stats(M:tManager); 
begin
  showStats(M);
end;

PROCEDURE readTasks(filename:string);

VAR
   usersFile  : TEXT;
   line          :STRING;
   //code          :STRING;
   //param1, param2, request:string;
   Q:tQueue;
   M:tManager;
   itemQ:tItemQ;
   
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
   
   createEmptyQueue(Q);
   
   WHILE NOT EOF(usersFile) DO
   BEGIN
      { Read a line in the file and save it in different variables}
      ReadLn(usersFile, line);
      itemQ.code := trim(copy(line,1,2));
      itemQ.request:= line[4];
      itemQ.param1 := trim(copy(line,5,10)); { trim removes blank spaces of the string}
                                         { copy(s, i, j) copies j characters of string s }
                                       { from position i }
      itemQ.param2 := trim(copy(line,15,10));
      enqueue(itemQ,Q);
   END;
   Close(usersFile);
   createEmptyManager(M);
    
    while not isEmptyQueue(Q) do begin
      itemQ:=front(Q);
      dequeue(Q);
      with itemQ do begin     
          {CHANGE writeln for the corresponding operation}
	    case request of
          'C':begin
              writeln('********************');
              writeln(code, ' ', request, ': center ', param1, ' totalvoters ', param2);
              writeln;
              Create(param1,param2,M);
              end;
          'N':begin	
              writeln('********************');
              writeln(code, ' ', request, ': center ', param1, ' party ', param2);
              writeln;
              New(param1,param2,M);
              end;
          'R':begin	
              writeln('********************');
              writeln(code, ' ', request, ':');
              writeln;
              Remove(M);
              end;
          'V':begin	
              writeln('********************');
              writeln(code, ' ', request, ': center ', param1, ' party ', param2);
              writeln;
              Vote(param1,param2,M);
              end;
          'S':begin
              writeln('********************');
              writeln(code, ' ', request, ':');
              writeln;
              Stats(M);  
              end;                            
        end;
      end;
    end;

   deleteManager(M);
END;


{Main program}

BEGIN
   
    if (paramCount>0) then
        readTasks(ParamStr(1))
    else
        readTasks('create.txt');

END.
