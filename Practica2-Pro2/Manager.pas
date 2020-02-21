unit Manager;

interface
USES CenterList, PartyList;

TYPE
tManager=tCenterList;

implementation

PROCEDURE createEmptyManager (var M:tManager);
begin
	createEmptyList(M);
end;
