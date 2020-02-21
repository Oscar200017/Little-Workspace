%Ejercicio1_13:
syms a b c x; solve(a*x^2 + b*x + c == 0, x)
%Se obtiene la formula para resolver una raiz cuadrada
syms a b c x; solve(a*x^2 + b*x + c == 0, a)
%Despeja el parametro a
syms x y; [x, y] = solve(2*x + 5*y == 0, x + y == 3)
%Da el resultado de x e y