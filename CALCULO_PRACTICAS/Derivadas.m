%Explicación Derivadas:

syms x
f(x)=x^3-4*x^2
df(x)=diff(f(x),x,1)
x0=solve(df(x)==0,x)
x0(1)
d2f(f(x),x,2)
d2f(x0(1))
d2f(x0(2))
