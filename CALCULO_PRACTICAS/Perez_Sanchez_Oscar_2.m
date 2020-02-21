%Perez Sanchez, Oscar DNI 49203911B Grupo 2.4 

%Ejercicio 2

%Sexa a funcion f(x) = x/x^2+1

%a)Determina a existencia de asintotas.
pkg load symbolic
syms x;

f(x) = (x/((x*x)+1))

limit(f(x),x,-inf,'left')
limit(f(x),x,-inf,'right')
limit(f(x),x,inf,'left')
limit(f(x),x,inf,'right') 
%Asintota horizontal en 1, no hay asintotas oblicuas por haber horizontal ni verticales porque
%el denominador no se anula nunca

%b)Determina os puntos criticos e indica de que tipo son. Determina se hai puntos de inflexion.
derivada1 = diff(f(x),x);
puntoscriticos = solve(derivada1==0,x) %Puntos criticos -1 y 1

puntocrit_neg = subs(f(x),x,-1) %Mínimo en (-1,-1/2)
puntocrit_pos = subs(f(x),x,1)  %Máximo en (1,1/2)

derivada2 = diff(f(x),x,2);
posible_punto_inflexion = solve(derivada2==0,x) %Posibles punto de inflexion en raiz de -3 y raiz de 3
derivada3 = diff(f(x),x,3)
pto_inf = solve(derivada3==0,x) %Puntos de inflexion en -1 +sqrt(2); 1 + sqrt(2); - sqrt(2) -1; - sqrt(2) +1 

%c)Estuda a monotonia da funcion, e dicir, os intervalos de crecemento e decrecemento.
subs(f(x),x,-inf)
subs(f(x),x,-1)  %decrece desde -inf hasta -1
subs(f(x),x,0)
subs(f(x),x,1)   %crece desde -1 hasta 1
subs(f(x),x,inf) %decrece desde 1 hasta inf
%d)Estuda os intervalos de concavidade e convexidade
subs(f(x),x,-1)  %convexa desde -inf a -1
subs(f(x),x,0)   %concava desde -1 hasta 1
subs(f(x),x,1)   %convexa desde 1 hasta inf

%e)Representa a funcion f, as suas asintotas e puntos criticos na mesma grafica. Emprega
%o color azul para f, o negro para as asintotas e asteriscos verdes para os extremos relativos
%e puntos de inflexion.
figure(1);
hold on 
axis([-20 20 -20 20]) ;
ezplot(f(x), [-20,20])
a = limit(f(x),x,inf)
m = [-20:1:20]
y0 = m*0 + double(a);
plot(m, y0, 'k')
plot(-1,-1/2, 'p')
plot(1,1/2, 'p')
plot(sqrt(-3), 'p')
plot(sqrt(3), 'p')