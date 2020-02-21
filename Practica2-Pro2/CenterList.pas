unit CenterList;
{Titulo: Programming II Labs
Subtitulo: Practica 2
Autor 1: Oscar Perez Sanchez  Login 1: oscar.perez.sanchez
Autor 2: David Bermudez Lopez  Login 2: david.bermudez
Grupo: 2.1
Fecha: 03/05/2019}
interface
USES SharedTypes, PartyList;
 
CONST 
MAXC = 25;
BLANKVOTE = 'B';
NULLCVOTE = 'N';
NULLC = 0;

TYPE
tPartyName= string;
tNumVotes= integer;
tCenterName= string;
tPosC= NULLC..MAXC;
tItemC= record
centername: tCenterName;
totalvoters: tNumVotes;
validvotes: tNumVotes;
partylist: tList;
end;
tListC= record
database: array[1..MAXC] of tItemC;
fin:tPosC;
end;

PROCEDURE createEmptyListC(var LC:tListC);
FUNCTION isEmptyListC(LC:tListC):boolean;
FUNCTION firstC(LC:tListC):tPosC;
FUNCTION lastC(LC:tListC):tPosC;
FUNCTION nextC(p:tPosC; LC:tListC):tPosC;
FUNCTION previousC(p:tPosC; LC:tListC):tPosC;
FUNCTION getItemC(p:tPosC; LC:tListC):tItemC;
FUNCTION insertItemC(d:tItemC; var LC:tListC):boolean;
PROCEDURE deleteAtPositionC(p:tPosC; var LC:tListC);
PROCEDURE updateListC(L:tList; p:tPosC; LC:tListC);
PROCEDURE updateValidVotesC(vt:tNumVotes; p:tPosC; var LC:tListC);
FUNCTION findItemC(cn:tCenterName; LC:tListC):tPosC;

implementation

PROCEDURE createEmptyListC(var LC:tListC); {Crea una lista vacía}
begin
   LC.fin:=NULLC;  
end; 


FUNCTION isEmptyListC(LC:tListC):boolean; {Comprueba si la lista actual está vacía devolviendo TRUE si no contiene elementos}
begin
    isEmptyListC:=LC.fin=NULLC; 
end;


FUNCTION firstC(LC:tListC):tPosC; {Devuelve por pantalla el primer valor no nulo de la lista}
begin
     firstC:=1;
end;


FUNCTION lastC(LC:tListC):tPosC;  {Devuelve el ultimo elemento introducido en la lista}
begin
   lastC:=LC.fin;
end;


FUNCTION nextC(p:tPosC; LC:tListC):tPosC; {Muestra por pantalla el elemento siguiente al especificado}
begin
  if (p< lastC(LC)) then
    nextC:= p+1
  else nextC:= NULLC;  {Si es la ultima posicion devolverá un 0}
end;


FUNCTION previousC(p:tPosC; LC:tListC):tPosC;  {Muestra por pantalla el elemento anterior al especificado}
begin
  if (p <> firstC(LC)) then
    previousC:= p-1
  else previousC:= NULLC;  {Si es la primera posicion devolverá un 0}
end;


FUNCTION getItemC(p:tPosC; LC:tListC):tItemC;  {Permite obtener un item de una posicion concreta por pantalla}
begin
   getItemC:=LC.database[p];
end;

function insertItemC(d:tItemC;var LC:tListC):boolean;
var	p:tPosC;
begin 
	if LC.fin=MAXC then
		insertItemC:=FALSE
	else begin	
		insertItemC:=TRUE;
		LC.fin:=LC.fin+1;
		p:=LC.fin;
		while LC.database[p-1].centername > d.centername do begin
			LC.database[p]:=LC.database[p-1];
			p:=p-1;
		end;
		LC.database[p]:=d;	
	end;
end;


PROCEDURE deleteAtPositionC(p:tPosC; var LC:tListC);  {Permite borrar un item y mover los demas una posicion dependiendo de donde haya sido borrado}
var ini:tPosC;
begin
   LC.fin:=LC.fin -1;  {Reduce los espacios de la lista en 1}
   for ini:= p to LC.fin do
     LC.database[ini]:=LC.database[ini+1];  {Reasigna al item siguiente el valor que tenia el anterior}
end;

PROCEDURE updateListC(L:tList; p:tPosC; LC:tListC);
begin
   LC.database[p].partylist:=L;
end;

PROCEDURE updateValidVotesC(vt:tNumVotes; p:tPosC; var LC:tListC);  {Cambia el numero de votos por partido introducidos}
begin
  LC.database[p].validvotes:=vt;
end;


FUNCTION findItemC(cn:tCenterName; LC:tListC):tPosC;
var p:tPosC; d:tItemC;
begin
  if isEmptyListC(LC) then findItemC:=0
   else begin
      p:=1;
      d:=LC.database[p];
      while (p < LC.fin) and (cn <> d.centername) do begin
         p:=p+1;
         d:=LC.database[p];
         if d.centername = cn then begin
             findItemC:= p;
             p:=LC.fin;
         end
         else findItemC:=0;
      end;
    end;
  
end;

{*********************************************************************************************************************************************************************************}
BEGIN
   
END.

