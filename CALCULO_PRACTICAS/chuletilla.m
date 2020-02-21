
% IMPORTANTE LEER : Igual hay algun fallo, pero seguramente cuando lo veais ya
% os dareis cuenta si teneis una nocion de calculo. Cualquier error, corregidlo
% y avisad, por favor.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% BASICO %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Carga de paquete simbolico

pkg load symbolic
syms x


% Comandos de ayuda

doc, help, letras y tabulador para ver que comandos tienen esas letras


% Comandos útiles

Usamos ; al final para realizar una operación pero no mostrarla

% Comandos de limpieza

clc, home, clear all, clear %variable%


% Formatos

Format short, format rat, format long, format long e


% Operaciones

+, -, *, /, ^,


% Funciones

sqrt(n), nthroot(x,n), exp(n), abs(n), log(n),
log10(n), log2(n), sin(n), cos(n), tan(n), factor(n),
factorial(n)

% Aproximar valor a una fraccion

fraccion = rats(2.5)


% Partes enteras y redondeo

fix(1.5), floor(1.5), round(1.5)

% Vector de ceros

vector_ceros = zeros(1,5)


% Mostrar elementos de un vector

vector = [1 2 3 4 5];   %en fila%
vector = [1; 2; 3; 4; 5];  %en columna%
vector = [1 2 3 4 5]';    %en columna%
vector(2)
vector([1,3])
vector([1:3])
zeros(a,b)
a:b:c
a:b


% Crear vector con saltos

vector1 = linspace(1,10,5)  %  5 numeros del 1 al 10
vector2 = [1:2:10]    % Desde el 1 hasta el 10 sumando 2


% Longitud de un vector

longitud_vector = length(vector)



% Operaciones con vectores


v = vector.^5
v = vector(5).*5
v = v./vector
v = vector + [1 2 3 4 5]
v = vector + 5

suma = suma(vector)
producto = prod(vector)
maximo = max(vector)
minimo = min(vector)


% Archivo de funcion (con el nombre funcion)

pkg load symbolic
syms x

function y = funcion(x)   % Llamar a la funcion utilizando funcion(1)
  y = cos(4*x) + sin(2*x)
endfunction


% Constantes simbolicas

pi = sym('pi')
e = sym('E')

% Constante simbolica a valor numerico

alpha = sym('pi')
beta = double(alpha)

vpa(1/3,5)    % Aproximacion con al menos 5 decimales


% Operar con expresiones simbolicas


funcion = x^2 + 5;

findsym(funcion)    % Muestra la variable simbolica de la funcion

solve(funcion == 0, x)    % Raices de la funcion
[x,y] = solve(2*x + y == 0, x + y == 3)   % Sistema de ecuaciones

subs(funcion,x,0)   % Resuelve la funcion para x = 0
    % Ejemplo con varias variables
      syms a b
      funcion = a*x^2 + 5*b*x;
      subs(funcion,{a,b},{1,2})   % Sustituye las variables a y b por 1 y 2


% Textos

disp('Este texto se muestra en pantalla')
disp('   ')   % Linea en blanco

a = 5;
disp (['El resultado es ', num2str(a)])  % Muestra texto con un numero cambiado a cadena

error('Error')

fprintf('El resultado es %8.3f', a)
fprintf('\n')   % Salto de linea

variable = input('Introduzca un numero : ')
cadena = input('Introduzca su nombre : ','s')
opcion = menu('MENU','Introducir nombre','Introducir edad')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% GRAFICAS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

pkg load symbolic
syms x


% Graficar poligonal que une varios puntos (x,y)

x = [1 3 5];
y = [2 1 4];

plot(x,y)


% Darle belesa a la grafica

title('Titulo grafica')
xlabel('Eje de abscisas')
ylabel('Eje de ordenadas')
text(1,2, 'Este es el punto (1,2)')
legend('texto linea')

axis equal  % Misma escala en ambos ejes
vector_ejes = axis    % Formados por los valores minimos y maximos de cada eje
axis([1 10 1 10])   % Modifica los valores minimos y maximos de cada eje

grid, grid off    % Cuadricula

plot(x,y,'cp--')


% Graficas con varias funciones

x = 0:1:10;
y = sin(x);
z = atan(x);

plot(x,y)
hold on
plot(x,z, 'g.-')
hold off


% Graficas en distintas ventanas

plot(x,y)
figure(2)
plot(x,z)

% Varias graficas en la misma ventana

funcion = x;
vector = [1:5];

subplot(2,1,1)
grafica1 = ezplot(funcion, [vector(1), vector(5)]);
subplot(2,1,2)
grafica2 = ezplot(funcion, [vector(1), vector(5)]);


% Graficar funcion a trozos

x = linspace(-2,3,1000);
y = (1 - 2*x).*(x <= -1) + ((x+1).^3 + 2*x).*(x > -1);
plot(x,y,'y.')


% Graficar con variables simbolicas

funcion = 2x^2 + 3;
grafica = ezplot(funcion,[-10,10])    % Grafica la funcion en el intervalo [-10,10]
hold on
set(grafica,'color','m','linestyle','.-');


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% LAGRANGE, MATRICES %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

pkg load symbolic
syms x


% Diferencia entre cada elemento de un vector y su siguiente

vector = [2, 3, 1, -1, 1/2];
diff(vector)


% LAGRANGE

anos = [2011 2013 2014];
SM = [2945 -1128 -94];
anos1 = anos;

l0 = 1;
l1 = 1;
l2 = 1;

for k = 2:3
  l0 = l0*(x-anos(k));
  l0 = l0/(anos(1)-anos(k));
endfor

for k = 1:2:3
  l1 = l1*(x-anos(k));
  l1 = l1/(anos(2)-anos(k));
endfor

for k = 1:2
  l2 = l2*(x-anos(k));
  l2 = l2/(anos(3)-anos(k));
endfor

% polinomio de grado 2

P2 = SM(1)*l0 + SM(2)*l1 + SM(3)*l2

subs(P2, x, 2012)
subs(P2, x, 2011)
subs(P2, x, 2013)
subs(P2, x, 2014)

% Calculo polinomio interpolador con diferencias divididas

syms x;

anos = [ 2005 2006 2007 2009 2010];
SM = [ 6915 7644 9396 3849 3679];

dif_x = diff(anos);
dif_y = diff(SM);
dif_1 = dif_y./dif_x
dif_2_y = diff(dif_1);
m = length(dif_2_y);
dif_2 = zeros(m, 1);

for k = 1:m
  dif_2(k) = dif_2_y(k)/(anos(k+2)-anos(k));
endfor

dif_2

dif_3_y = diff(dif_2);

m = length(dif_3_y);
dif_3 = zeros(m, 1);

for k = 1:m
  dif_3(k) = dif_3_y(k)/(anos(k+3)-anos(k));
endfor

dif_3

dif_4_y = diff(dif_3);
m = length(dif_4_y);
dif_4 = zeros(m, 1);

for k = 1:m
  dif_4(k) = dif_4_y(k)/(anos(k+4)-anos(k));
endfor

dif_4

P5 = SM(1)+dif_1(1)*(x-anos(1))...
+dif_2(1)*(x-anos(1))*(x-anos(2))...
+dif_3(1)*(x-anos(1))*(x-anos(2))*(x-anos(3))...
+dif_4(1)*(x-anos(1))*(x-anos(2))*(x-anos(3))*(x-anos(4))

subs(P5, x, 2008)
subs(P5, x, 2005)
subs(P5, x, 2006)
subs(P5, x, 2007)
subs(P5, x, 2009)

subplot(2,1,1)
gr1 = ezplot(P2, [anos1(1), anos1(end)]);
subplot(2,1,2)
gr2 = ezplot(P5, [anos(1), anos(end)]);

% MATRICES

Matriz_2x2 = [1 2; 3 4]
Elemento_M22 = M(2,2)  % Elemento segunda fila segunda columna 
Elementos_fila = M(1,:)  % Todos los elementos de la primera fila
Elementos_matriz = M(1:2,:)  % Muestra los elementos que estan de la fila 1 a la fila 2 y en todas las columnas



% Matriz de elementos aleatorios entre 0 y 1

Matriz = rand(5) % 5x5
Matriz = rand(2,4) % 2x4


% Tamaño de una matriz


Matriz = [1 2 3 4; 4 5 6 7];  % 2x4
[m,n] = size(Matriz)  % Muestra el numero de filas y columnas de la matriz


% Matriz de unos o de ceros


Matriz_unos = ones(3,2)
Matriz_ceros = zeros(3)


% Dicotomia

f = x^3-x-1;
a = 1.3;
b = 1.4;
a1 = a;
b1 = b;
alpha = solve(f==0,x);
alpha = alpha(1);
alpha = double(alpha);

pause(3)
format long
for k = 1:fix(log2((b-a)*10^5))+1
  xk = 0.5*(a1+b1);
  fprintf('xk =  %5.4f\n', xk)
  
%  fprintf('fa1 =  %6.4f\n', subs(f,x,a1))
%  fprintf('fxk =  %6.4f\n', subs(f,x,xk))
  if (double(subs(f,x,a1))*double(subs(f,x,xk))<0) 
%    a1 = a1;
    b1 = xk;
    
  else
    a1 = xk;
  endif
fprintf('a1 =  %5.4f\n', a1)
fprintf('b1 =  %5.4f\n', b1)
endfor

fprintf('El error es %8.6f', alpha-xk)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% DERIVADAS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

pkg load symbolic
syms x

f = x*exp(x);


% Derivada de la funcion f

derivada = diff(f,x)


% Derivada de orden n de la funcion f

n = 3;

derivada_orden_n = diff(f,x,n)


% Extremos relativos de la funcion f

extremos_relativos = solve(derivada==0,x)

    % Si f''(x0) > 0 maximos relativo
    % Si f''(x0) < 0 minimo relativo 


% Posibles extremos absolutos

a = 0;
b = 2;

posibles_extremos_absolutos = [double(extremos_relativos),a,b];

n = length(posibles_extremos_absolutos);

extremo_evaluado = zeros(1,n);

for k = 1:n
valor_extremo = subs(f,x,posibles_extremos_absolutos(k))
fprintf('El valor de f en el extremo relativo %8.2d es %8.2f \n', posibles_extremos_absolutos(k), double(valor_extremo));
endfor


% Crecimiento de la funcion f en cada intervalo


derivada = diff(f,x);
raices = solve(der==0,x);
crecimiento = subs(der,x,%aqui se pone la raiz)

% Posibles puntos de inflexión de la funcion f, ¿concava o convexa?

derivada_segunda = diff(f,x,2);
posible_punto_inflexion = solve(derivada_segunda==0,x)
derivada_tercera = diff(f,x,3)

evaluada = subs(derivada_tercera,x,posible_punto_inflexion(2));

if (double(evaluada)!=0)
  fprintf('punto de inflexion de f es %8.3f', double(posible_punto_inflexion(2)))
endif

    % Si f''>0 entonces f' es convexa en [0,posible_punto_inflexion] y creciente
    % Si f''<0 entonces f' es concava en [0,posible_punto_inflexion] y decreciente

figure(2)
ezplot(derivada_segunda,[0,100]) 
figure(3)
ezplot(derivada_segunda,[0,double(posible_punto_inflexion(2))])

% Polinomio de Taylor de orden 2

polinomio_taylor_orden_3 = taylor(f,x,'order',3)


% Limite de una funcion en un punto


limite = limit(f,x,0)


% Limites laterales

limite_derecha = limit(f,x,0,'right')
limite_izquierda = limit(f,x,0,'left')


% Asintotas horizontales

asintota_horizontal = limit(f,x,inf) % Comprobamos los limites laterales. Todos tienen que dar el mismo valor finito
asintota_horizontal = limit(f,x,inf, 'left')
asintota_horizontal = limit(f,x,inf, 'right')

% Asintotas verticales


asintota_vertical = limit(f,x,1) % Comprobamos los limites laterales. Todos tienen que dar infinito
asintota_vertical = limit(f,x,1, 'left')
asintota_vertical = limit(f,x,1, 'right')

% Asintotas oblicuas. Recordar y = mx + n; solo hay cuando no existen asintotas horizontales 
% y cuando el grado del numerador es uno mayor que el del denominador


m = limit(f/x,x,inf);
n = limit(f-m*x,x,inf);

asintota_oblicua = m*x + n


% Recta tangente


ezplot(x,f);
hold on

x0 = 2;
f0 = diff(f,x);
fx = subs(f,x,x0);
m = subs(f0,x,x0);

tangente = m * (x - x0) + fx
ezplot(x,tangente)




%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% INTEGRALES %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%              

pkg load symbolic
syms x

f = x^3 + 2*x;

% Primitiva de la funcion f

primitiva = int(f,x)

% Integral de f definida en un intervalo [a,b]

a = 0;
b = 2;

integral_definida = int(f,x,a,b)

% Integral impropia de f

a = -inf;
b = inf;

integral_impropia = int(f,x,a,b)

% Aproximar integral definida de f en un intervalo [a,b] por el método del punto medio

a = 0;
b = 2;

punto_medio = (a + b) / 2;
integral_punto_medio = subs(f,x,punto_medio) * (b - a)

% Aproximar integral definida de f en un intervalo [a,b] por el método del trapecio compuesto

for n = 1:5
  nodos = linspace(a,b,10^n);
  funcion_evaluada = nodos.^3 + 2.*nodos;
  integral_trapecio_compuesto = trapz(nodos,funcion_evaluada)
endfor

