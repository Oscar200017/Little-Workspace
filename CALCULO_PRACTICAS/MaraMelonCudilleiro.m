
%--------------Ejercicio 1 del examen--------------------

pkg load symbolic
syms x
h(x)= (x^2-3)/(x^2+8*x+16);

%REPRESENTACION GRAFICA
figure(1);
hold on 
axis([-50 50 -50 50]) ;
ezplot(h(x),[-50,50]);

m=[-50:1/10:50]; %vector del intervalo dividido
y0=0*m ;%recta y0=0 para colocar los ejes.
plot(y0,m,'g');
plot(m,y0,'g');


%Asintotas de h

a=limit(h(x),x,inf) %asintota horizontal en 1 hacia infinito
limit(h(x),x,inf, 'left')
limit(h(x),x,inf, 'right')
limit(h(x),x,-inf); %asintota horizontal en 1 hacia menos infinito.
limit(h(x),x,-inf, 'left')
limit(h(x),x,-inf, 'right')
y0= 0*m + double(a);
plot(m,y0,'r -.');

[num,den]=numden(f); %separar el numerador del denominador
t=solve(den==0); % despejar cuando el denominador se anula , -4.
y0=0*m -4; %recta de la asintota VERTICAL en -4
plot(y0,m,'y');

%como hay asintotas horizontales ya no puede haber asintotas oblicuas.

%EXTREMOS RELATIVOS DE h(x)

derivada1=diff(h(x),x)
puntoscriticos=solve(derivada1==0,x) %punto critico en -3/4

subs(h(x),x,-3/4)  % hay un minimo relativo en (-3/4, -3/13) porque h'(3/4) < 0
plot(-3/4,-3/13)
text(-3/4,-3/13, 'Minimo absoluto en (-3/4,-3/13)')

%CONCAVIDAD DE h(x) y PUNTOS INFLEXION

derivada2 = diff(h(x),x,2);
posible_punto_inflexion = solve(derivada2==0,x) %posible punto inf en 7/8
derivada3 = diff(h(x),x,3)
solve(derivada3==0,x) % Punto de inflexion en (7/8,5/2)

subs(h(x),x,(7/8)) % < 0 funcion concava

%-------------Ejercicio 2--------------------------------------

pkg load symbolic
syms t
c(t)=0.01*t^3 -0.45*t^2 + 2.43*t +300

%cotización máxima y mínima
%utilizare como intervalo un mes [1,30]
derivada1=diff(c(t),t)
solve(derivada1==0,t) %puntos criticos 3 y 27

%sustituyo los extremos del intervalo y los puntos criticos para ver su valor y comparar.
c(3) % c=303.51 MAXIMO ABSOLUTO
c(27)% c= 234.39 minimo absoluto
c(1)%c= 301.99 Maximo relativo
c(30)%c= 237.9 Minimo relativo
















