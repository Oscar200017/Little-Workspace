%Ejercicio_4.1
pkg load symbolic
syms x;

int(x*log(x),x)

int(atan(x),x)

syms u;
int(u^2/sqrt(u^3+1),u)

int((x^2)+(1/cbrt(x)),x,1,2)

int(sqrt(9-x^2),x,-3,3)

%Ejercicio_4.2
int(log(x)/x^2,x,1,+inf)
F(x)=int(log(x)/x^2,x)
syms M;
limit(F(M)-F(1),M,inf)

int(1/1+x^2,x,-inf,+inf)
F(x)=int(1/1+x^2,x)
syms M N;
limit(limit(F(M)-F(N),M,inf),N,-inf)

int(1/sqrt(-x),x,-4,0)+int(1/sqrt(x),x,-4,0)
F(x)=int(1/sqrt(-x),x)
G(x)=int(1/sqrt(x),x)ç
limit(G(x)
%Ejercicio_4.3
function a=midp(x,y)
  a=(x(1)-x(0))*sum(y)
endfunction


