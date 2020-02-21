unit RequestQueue;
{Titulo: Programming II Labs
Subtitulo: Practica 2
Autor 1: Oscar Perez Sanchez  Login 1: oscar.perez.sanchez
Autor 2: David Bermudez Lopez  Login 2: david.bermudez
Grupo: 2.1
Fecha: 03/05/2019}
interface

CONST
NULLQ = 0;
MAXQ = 1000;

TYPE
tRequest = char;
tPosQ = integer;
tItemQ = record
request:tRequest;
code:string;
param1:string;
param2:string;	
end;
tQueue = record
datab: array[1..MAXQ] of tItemQ;
ini, fin: 0..MAXQ;
end;

PROCEDURE createEmptyQueue(var Q:tQueue);
FUNCTION addOne(i:integer):integer;
FUNCTION isEmptyQueue(Q:tQueue):boolean;
FUNCTION enqueue (d: tItemQ; var Q: tQueue):boolean;
FUNCTION front(Q:tQueue):tItemQ;
PROCEDURE dequeue(var Q:tQueue);

implementation

PROCEDURE createEmptyQueue(var Q:tQueue);
begin
   Q.ini:=1;
   Q.fin:=MAXQ;
end;

FUNCTION addOne(i:tPosQ):tPosQ;
begin
  if i=MAXQ then addOne:=1
  else addOne:=i+1;
end;

FUNCTION isEmptyQueue(Q:tQueue):boolean;
begin
   isEmptyQueue:=(Q.ini=addOne(Q.fin));
end;

FUNCTION enqueue (d: tItemQ; var Q: tQueue):boolean;
begin
  if Q.ini = addOne(addOne(Q.ini)) then enqueue:=FALSE
  else begin
  enqueue:=TRUE;
  Q.fin:= addOne(Q.fin);
  Q.datab[Q.fin]:=d;
  end;
end;

FUNCTION front(Q:tQueue):tItemQ;
begin
   front:=Q.datab[Q.ini];
end;

PROCEDURE dequeue(var Q:tQueue);
begin
  Q.ini:=addOne(Q.ini);
end;

{*********************************************************************************************************************************************************************************}
BEGIN
   
END.

