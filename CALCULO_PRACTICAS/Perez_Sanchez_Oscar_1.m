%Perez Sanchez, Oscar DNI 49203911B Grupo 2.4 

%Ejercicio 1
%Sexa a funcion f(x) = 8x/1+x^2

%a)Calcula de forma exacta a area delimitada pola funcion f e o eixe X no intervalo [0,4].
pkg load symbolic
syms x;

f(x) = (8*x)/(1+x^2)

area = int(f(x),0,4)  %EL area da 64/17, asi que en la variable de abajo la paso a decimal

solucion_a = 64/17    %Solucion del apartado a = 3.7647 unidades^2

%b)Aproxima a area anterior mediante as formulas de Trapecio simple e Simpson. Compara os
%resultados obtidos co valor exacto. 
trapecio = ((4-0)/2)*(f(0)+f(4))  %64/17 = 3.7647     
simpson = ((4-0)/6)*(f(0)+(4*f((0+4)/2))+f(4))  %832/85 = 23.771

%c)Obten a expresion do polinomio de Taylor de orde 2 relativo a f no punto x0 = 4.
%Compara o valor de f e o seu polinomio de Taylor en x = 3.
syms x0;

P_o(x0) = f(x0) + (diff(f(x0),x0)*(x-x0))/1 + (diff(f(x0),x0,2)*((x-x0)^2))/2 %Polinomio Taylor orden 2

P_o(4) %Expresion: -120*x/289 +  416*((x - 4)^2)/ 4913 + 1024/289

x = 3;       
P_o2(x0) = f(x0) + (diff(f(x0),x0)*(x-x0))/1 + (diff(f(x0),x0,2)*((x-x0)^2))/2

P_o2(4)

sol_P_o2 = 11704/4913
sol_f3 = f(3)
