program main;
{Titulo: Programming II Labs
Subtitulo: Practica 1
Autor 1: Oscar Perez Sanchez  Login 1: oscar.perez.sanchez
Autor 2: David Bermudez Lopez  Login 2: david.bermudez
Grupo: 2.1
Fecha: 15/03/2019}
USES sysutils,DynamicList;

{Procedure New
Objetivo: Crea un nuevo partido en la lista con votos inicializados a 0
Entrada: Una lista vacia o con algun partido (si se esta volviendo a usar NEW)
Salida: Mensaje de inclusión de partido o error
PreCD: Que exista una lista vacia ya creada
PostCD: Votos inicializados a 0}
procedure New(pt:tPartyName; var L:tList);     
var d: tItem;
begin
    if findItem(pt,L)=NULL then begin
      d.partyname:=pt;
      d.numvotes:=0;
      insertItem(d, NULL, L);
      writeln('* New: party ', pt)
    end  
    else writeln('+ Error: New not possible');
end;

{Procedure Vote
Objetivo: Añade un voto al partido seleccionado actualizando la lista
Entrada: Lista con partidos
Salida: Mensaje de añadir voto o error al votar a un partido inexistente
PreCD: Que exista una lista ya creada con partidos en ella
PostCD: Porcentajes de votos y participacion correctos respecto a totalvoters}
procedure Vote(pt:tPartyName; var L:tList);   
var p: tPosL; d: tItem;
begin
    p:= findItem(pt,L);
    if p <> NULL then begin
        d:=getItem(p, L);
		d.numvotes:=d.numvotes+1;
		updateVotes(d.numvotes,p,L);
		writeln('* Vote: party ', pt, ' numvotes ', d.numvotes);
		end
	else begin
		p:= findItem('N',L);
		d:= getItem(p,L);
		d.numvotes:=d.numvotes+1;
		updateVotes(d.numvotes,p,L);
		writeln('+ Error: Vote not possible. Party ', pt,' not found. NULLVOTE');
		end
end;

{Procedure Stats
Objetivo: Muestra la lista con sus partidos y el numero de votos de cada uno
Entrada: Datos de Partidos y Votos
Salida: Lista por pantalla
PreCD: Que exista una lista ya creada
PostCD: }
procedure Stats(totalvoters: integer; var L:tList);
var
	p, p1, p2: tPosL;
	d1, d2: tItem;
	valides: integer; 
	nulls: integer;
begin
	valides := 0;
	nulls:=0;
	
	p:= first(L);
	while p <> NULL do begin
	  if getItem(p, L).partyname <> 'N' then
	    valides:= valides + getItem(p, L).numvotes
	  else nulls:= getItem(p, L).numvotes + nulls;
	  p:= next(p, L);
	end;

	p1:= findItem(BLANKVOTE, L);
	d1:= getItem(p1, L);
	p2:=findItem(NULLVOTE, L);
	d2:=getItem(p2, L);
	if valides <> 0 then writeln('Party ', BLANKVOTE, ' numvotes ', d1.numvotes, ' (',(d1.numvotes/valides)*100:0:2,'%)')
	else writeln('Party ', BLANKVOTE, ' numvotes ', d1.numvotes, ' (0.00%)'); 
	writeln('Party ', NULLVOTE, ' numvotes ', d2.numvotes);
	p:= next(p2, L);
	while p <> NULL do begin
	    if valides <> 0 then writeln('Party ', getItem(p, L).partyname, ' numvotes ', getItem(p, L).numvotes, ' (',(getItem(p, L).numvotes/valides)*100:0:2,'%)')
		else writeLn('Party ', getItem(p, L).partyname, ' numvotes ', getItem(p, L).numvotes, ' (0.00%)');
		p:= next(p,L);
	end;  	
	writeln('Participation: ', valides + nulls, ' votes from ', totalvoters, ' voters (', ((valides+nulls)/totalvoters)*100:0:2, '%)');
end;
	

{Procedure Illegalize
Objetivo: Hace ilegal un partido y lo elimina pasando sus votos al partido nulo
Entrada: Lista con partidos y votos
Salida: Mensaje de ilegalizacion de partido o error
PreCD: Que exista una lista ya creada con partidos y votos
PostCD: Partido ilegal borrado de la lista}
procedure Illegalize(pt: tPartyName; var L:tList);
var p, p2:tPosL; 
begin
  p:= findItem(pt, L);
  p2:=findItem(NULLVOTE, L);
  if (p = NULL) or (pt = BLANKVOTE) or (pt = NULLVOTE) then
  writeln('+ Error: Illegalize not possible ')
  else begin
  updateVotes((getItem(p, L).numvotes + getItem(p2, L).numvotes), p2, L);
  writeln('* Illegalize: party ', pt);
  deleteAtPosition(p, L)
  end;
end;

procedure readTasks(filename:string);
	
VAR
   usersFile: TEXT;
   code 	     :string;
   line          : STRING;
   task          : STRING;
   partyOrVoters : STRING;
   L: tList;
   totalvoters: integer;
BEGIN

   {process the operation file named filename}

   {$i-} { Deactivate checkout of input/output errors}
   Assign(usersFile, filename);
   Reset(usersFile);
   {$i+} { Activate checkout of input/output errors}
   IF (IoResult <> 0) THEN BEGIN
      writeln('**** Error reading '+filename);
      halt(1)
   END;
   createEmptyList(L);
   
   WHILE NOT EOF(usersFile) DO
   BEGIN
      { Read a line in the file and save it in different variables}
      ReadLn(usersFile, line);
      code := trim(copy(line,1,2));
      task:= line[4];
      partyOrVoters := trim(copy(line,5,8));  { trim removes blank spaces of the string}
                                          { copy(s, i, j) copies j characters of string s }
                                          { from position i }

      {Show the task --> Change by the adequate operation}
       writeln('********************');
		case task of
		'N':begin
		writeln(code, ' ',task,': party ',partyOrVoters);
		writeln('');
		New(partyOrVoters, L);
		end;
		'V':begin
		writeln(code, ' ',task,': party ',partyOrVoters);
		writeln('');
		Vote(partyOrVoters, L);
		end;
		'S':begin
		writeln(code, ' ',task,': totalvoters ',partyOrVoters);
		totalvoters:=StrToInt(partyOrVoters);
		writeln('');
		Stats(totalvoters, L);
		end;
		'I':begin
		writeln(code, ' ',task,': party ',partyOrVoters);
		Illegalize(partyOrVoters, L);
		end;	
		end;
  END;
   Close(usersFile);

END;


{Main program}
BEGIN
	if (paramCount>0) then
		readTasks(ParamStr(1))
	else
		readTasks('vote.txt');

END.
