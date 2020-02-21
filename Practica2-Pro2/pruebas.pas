PROCEDURE showStats(M:tManager);
var p:tPosC; d:tItemC; L:tList; p2:tPosL; d2:tItem; aux,valides,nulls:integer; 	
begin
	p:= firstC(M);
	while p <> NULLC do begin
		d:= getItemC(p,M);
		with d do begin
			writeln('Center ', centername);
			valides:=0;
			L:=d.partylist;
			aux:=d.totalvoters;
			p2:=first(L);
	         while p2 <> NULL do begin
			   d2:=getItem(p2,L);
			   if d2.partyname <> NULLVOTE then valides:= valides + d2.numvotes
			   else nulls:= d2.numvotes;
			   p2:= next(p2,L);
			 end;	
			 p2:= first(L);
			 while p2 <> NULL do begin
				d2:= getItem(p2,L);
				if d2.partyname <> NULLVOTE then begin
				  if valides <> 0 then 
				    writeln('Party ', d2.partyname, ' numvotes ', d2.numvotes, ' (',(d2.numvotes/valides)*100:0:2,'%)')
				  else writeln('Party ', d2.partyname, ' numvotes ', d2.numvotes, ' (',0.0:0:2 ,'%)');
				  end	
				else writeln('Party ', d2.partyname, ' numvotes ', d2.numvotes);
				p2:= next(p2,L);
			 end;	
		     writeln('Participation: ', valides+nulls, ' votes from ', aux, ' voters (', ((valides+nulls)/aux)*100:0:2, '%)');
			 writeln;
	    end;		
		p:=nextC(p,M);
	end;
end; 

FUNCTION insertCenter (cn:tCenterName; vt:tNumVotes; var M:tManager):boolean;
var d:tItemC; PB,PN:tItem; p:tPosC; L:tList;
	
begin
	p:=findItemC(cn,M);
	if p = NULLC then begin
	  insertCenter:= TRUE;
	  d.centername:=cn;
	  d.totalvoters:=vt;
	  d.validvotes:=0;
	  createEmptyList(L);	
	  PB.partyname:=BLANKVOTE;
	  PB.numvotes:=0;
	  insertItem(PB,L);
	  PN.partyname:=NULLVOTE;
	  PN.numvotes:=0;
	  insertItem(PN,L);
	  d.partylist:=L;
	  insertCenter:=insertItemC(d,M);
	end
	else insertCenter:= FALSE;
end;


