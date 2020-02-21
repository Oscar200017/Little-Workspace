unit StaticList;
{Titulo: Programming II Labs
Subtitulo: Practica 1
Autor 1: Oscar Perez Sanchez  Login 1: oscar.perez.sanchez
Autor 2: David Bermudez Lopez  Login 2: david.bermudez
Grupo: 2.1
Fecha: 15/03/2019}
interface
 
CONST 
MAX = 25;
NULL = 0;
BLANKVOTE = 'B';
NULLVOTE = 'N';

TYPE
tPartyName= string;
tNumVotes= integer;
tPosL= 0..MAX;
tItem= record
partyname: tPartyName;
numvotes: tNumVotes;
end;
tList= record
database: array [1..MAX] of tItem;
fin: tPosL;
end;


PROCEDURE createEmptyList(var L:tList);
FUNCTION isEmptyList(L:tList):boolean;
FUNCTION first(L:tList):tPosL; 
FUNCTION last(L:tList):tPosL; 
FUNCTION next(p:tPosL; L:tList):tPosL; 
FUNCTION previous(p:tPosL; L:tList):tPosL;
FUNCTION getItem(p:tPosL; L:tList):tItem; 
FUNCTION insertItem(d:tItem; p:tPosL; var L:tList):boolean;
PROCEDURE deleteAtPosition(p:tPosL; var L:tList);  
PROCEDURE updateVotes(vt:tNumVotes; p:tPosL; var L:tList);
FUNCTION findItem(pt:tPartyName; L:tList):tPosL;
   
implementation

PROCEDURE createEmptyList(var L:tList); {Crea una lista vacía}
begin
   L.fin:=NULL;  
end; 


FUNCTION isEmptyList(L:tList):boolean; {Comprueba si la lista actual está vacía devolviendo TRUE si no contiene elementos}
begin
    isEmptyList:=L.fin=NULL; 
end;


FUNCTION first(L:tList):tPosL; {Devuelve por pantalla el primer valor no nulo de la lista}
begin
     first:=1
end;


FUNCTION last(L:tList):tPosL;  {Devuelve el ultimo elemento introducido en la lista}
begin
   last:=L.fin;
end;


FUNCTION next(p:tPosL; L:tList):tPosL; {Muestra por pantalla el elemento siguiente al especificado}
begin
  if (p< last(L)) then
    next:= p+1
  else next:= NULL;  {Si es la ultima posicion devolverá un 0}
end;


FUNCTION previous(p:tPosL; L:tList):tPosL;  {Muestra por pantalla el elemento anterior al especificado}
begin
  if (p <> first(L)) then
    previous:= p-1
  else previous:= NULL;  {Si es la primera posicion devolverá un 0}
end;


FUNCTION getItem(p:tPosL; L:tList):tItem;  {Permite obtener un item de una posicion concreta por pantalla}
begin
   getItem:=L.database[p];
end;


FUNCTION insertItem(d:tItem; p:tPosL; var L:tList):boolean;  {Permite insertar un item y mover los demas una posicion dependiendo de donde se inserte}
var i:tPosL; 
begin
  if L.fin=MAX then 
   insertItem:=FALSE
  else begin 
    insertItem:=TRUE;
    L.fin:=L.fin+1;
    if p=NULL then
      L.database[L.fin]:=d
    else begin 
      for i:=L.fin downto p+1 do L.database[i]:=L.database[i-1];
    L.database[p]:=d;
    end;
  end;       
end;


PROCEDURE deleteAtPosition(p:tPosL; var L:tList);  {Permite borrar un item y mover los demas una posicion dependiendo de donde haya sido borrado}
var ini:tPosL;
begin
   L.fin:=L.fin -1;  {Reduce los espacios de la lista en 1}
   for ini:= p to L.fin do
     L.database[ini]:=L.database[ini+1];  {Reasigna al item siguiente el valor que tenia el anterior}
end;


PROCEDURE updateVotes(vt:tNumVotes; p:tPosL; var L:tList);  {Cambia el numero de votos por partido introducidos}
begin
  L.database[p].numvotes:=vt;
end;


FUNCTION findItem(pt:tPartyName; L:tList):tPosL;
var ini:tPosL;
begin
  ini:=1;
  if L.fin = NULL then findItem:= NULL;
  while (ini<L.fin) and (L.database[ini].partyname <> pt) do
    ini:=ini+1;
  if (ini<=L.fin) and (L.database[ini].partyname = pt) then
    findItem:=ini
  else findItem:=NULL;
end;

{*********************************************************************************************************************************************************************************}
BEGIN
   
END.
