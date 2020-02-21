%Ejercicio_2.1

1. Sea f la función definida por f(x) = x^2-9/x^2-4
(a) Determina el dominio de f. Determina los puntos de corte de la curva
y = f(x) con los ejes. Representa y = f(x) en el rectángulo [-10, 10] × [-3, 6]
junto con los ejes cartesianos, dibujados éstos en color verde.
(b) Determina las ecuaciones de las asíntotas horizontales y verticales de la
curva. ¿Por qué no existen asíntotas oblicuas?
(c) Añade las asíntotas a la gráfica anterior.

pkg load symbolic
syms x; 
solve(x^2-4==0) %puntos que se escapan del dominio R-{}

%puntos de corte con el eje x:
syms x;
solve((x^2-9)/(x^2-4))

%puntos de corte con el eje y:
syms x;
subs((x^2-9)/(x^2-4), x, 0)

%representacion dentro de un rectangulo:
figure
syms x;
ezplot((x^2-9)/(x^2-4))
axis([-10, 10, -3, 6])
hold on
plot([-10, 10],[0, 0], 'g')
plot([0, 0], [-3, 6], 'g')
hold off

%asisntotas:
display('Esta grafica solo tiene asintotas verticales, que se corresponden con 
los puntos que escapan a su dominio')


