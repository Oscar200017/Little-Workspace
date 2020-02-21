
%1)En 2015, la ONU aprobó la Agenda 2030 sobre el Desarrollo Sostenible marcando
%17 objetivos de desarrollo sostenible, conocidos por ODS. El número 12 nos pide
%garantizar modalidades de consumo y producción sostenibles, para lo cual es 
%necesario involucrar a los consumidores mediante la sensibilización y la 
%educación sobre el consumo y los modos de vida sostenibles. La marca de móviles
%USARYTIRAR ha introducido en el mercado un nuevo modelo cuyas ventas se
%modelan mediante:
%S(t) = 100000/1 + 50000 e-0.4t
%donde t es el tiempo en meses y S(t) representa el número total de unidades vendidas.

%1. Calcula las ventas para un tiempo suficientemente grande. Estudia las asíntotas de S.
syms t
S(t) = 100000/(1 + 50000*exp(-0.4*t))
disp('No tiene asintotas verticales porque el denominador nunca se anula, por lo que calculamos los limites laterales para comprobar si la funcion tiene asintotas horizontales')
limit(S(t),t,inf)
limit(S(t),t,-inf)
disp('Vemos que tiene asintotas horizontales en 100000 y 0')

%2. Estudia el crecimiento de S.
diff(S(t),t,1)
d1(t)= diff(S(t),t,1)
solve(d1(t)==0,t)
d1(1)
disp('Como podemos observar, la funcion es monotona creciente), ya que no existen puntos criticos')

%3. Calcula el punto de inflexión de las ventas. Analiza la concavidad y 
%convexidad, interpretando lo que representa.
diff(S(t),t,2)
d2(t)=diff(S(t),t,2)
solve(d2(t)==0,t)
disp('Ya que no existen puntos criticios, tampoco hay puntos de inflexion')

%4. Representa gráficamente en la misma ventana, empleando el comando subplot, 
%las tres funciones S(t), S'(t) y S''(t).
subplot(1,3,1)
ezplot(S(t), [10,50])
subplot(1,3,2)
ezplot(d1(t), [10,50])
subplot(1,3,3)
ezplot(d2(t), [10,50])
