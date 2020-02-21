%Ejercicio1_14:
syms x

y = (x^2 - 1)/(2*(x + 4)^3); numden(y)
[num, den] = numden(y)
factor(y)
expand(den)
z=(x^2 - 1)/(x^2 + 2*x + 1); simplify(z)
