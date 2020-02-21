unit DynamicList;
{Titulo: Programming II Labs
Subtitulo: Practica 1
Autor 1: Oscar Perez Sanchez  Login 1: oscar.perez.sanchez
Autor 2: David Bermudez Lopez  Login 2: david.bermudez
Grupo: 2.1
Fecha: 15/03/2019}
interface
 
CONST 
NULL = nil;
BLANKVOTE = 'B';
NULLVOTE = 'N';

TYPE
tPartyName= string;
tNumVotes= integer;
tPosL= ^tNode ;
tItem= record
partyname: tPartyName;
numvotes: tNumVotes;
end;
tNode = record
data: tItem;
sig: tPosL;
end;
tList= tPosL;


PROCEDURE createEmptyList(var L:tList);
FUNCTION isEmptyList(L:tList):boolean;
FUNCTION first(L:tList):tPosL; 
FUNCTION last(L:tList):tPosL; 
FUNCTION next(p:tPosL; L:tList):tPosL; 
FUNCTION previous(p:tPosL; L:tList):tPosL;
FUNCTION getItem(p:tPosL; L:tList):tItem; 
FUNCTION insertItem(d:tItem; p:tPosL; var L:tList):boolean;
PROCEDURE deleteAtPosition(p:tPosL; var L:tList);  
PROCEDURE updateVotes(vt: tNumVotes; p:tPosL; var L:tList);
FUNCTION findItem(pt:tPartyName; L:tList):tPosL;
   
implementation

PROCEDURE createEmptyList(var L:tList); {Crea una lista vacía}
begin
   new(L);
   L:=NULL;  
end; 


FUNCTION isEmptyList(L:tList):boolean; {Comprueba si la lista actual está vacía devolviendo TRUE si no contiene elementos}
begin
    isEmptyList:=L=NULL; 
end;

FUNCTION first(L:tList):tPosL; {Devuelve por pantalla el primer valor no nulo de la lista}
begin
     first:=L;
end;


FUNCTION last(L:tList):tPosL;  
begin
    while L^.sig<>NULL do L:=L^.sig;
    last:=L;
end;


FUNCTION next(p:tPosL; L:tList):tPosL; 
begin
  next:=p^.sig;  
end;


FUNCTION previous(p:tPosL; L:tList):tPosL;  
begin
  if p=L then
    previous:= NULL
  else begin
    while (L^.sig <> p) do L:=L^.sig;
    previous:=L;
  end;
end;


FUNCTION getItem(p:tPosL; L:tList):tItem;  
begin
   getItem:=p^.data;
end;


FUNCTION insertItem(d:tItem; p:tPosL; var L:tList):boolean;  
var s, t:tPosL; 
begin
  new(s);
  if s = NULL then 
   insertItem:=FALSE
  else begin 
    insertItem:=TRUE;
    if L=NULL then begin
     s^.data:=d;
     s^.sig:=NULL;
     L:=s;
    end
    else if p = NULL then begin
    t:= L;
    while t^.sig <> NULL do t:= t^.sig;
    s^.data:=d;
    s^.sig:=NULL;
    t^.sig:=s;
    end
    else begin
    s^.sig:=p^.sig;
    p^.sig:=s;
    s^.data:=p^.data;
    p^.data:=d;
    end; 
  end;       
end;


PROCEDURE deleteAtPosition(p:tPosL; var L:tList);  
var q:tPosL;
begin
   if L=p then
     L:=L^.sig
   else if p^.sig = NULL then begin
   q:=L;
   while q^.sig <> p do q:=q^.sig;
   q:=NULL
   end
   else begin
   q:=p^.sig;
   p^.sig:=q^.sig;
   p^.data:=q^.data;
   p:=q
   end;
   dispose(p);
end;

PROCEDURE updateVotes(vt: tNumVotes; p:tPosL; var L:tList); 
begin
  p^.data.numvotes:=vt;
end;


FUNCTION findItem(pt:tPartyName; L:tList):tPosL;
begin
  while (L <> NULL) and (L^.data.partyname <> pt) do L:=L^.sig;
  findItem:=L;
end;


{*********************************************************************************************************************************************************************************}
BEGIN
   
END.
