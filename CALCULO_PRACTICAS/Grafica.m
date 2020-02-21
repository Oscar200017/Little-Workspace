%Ejercicio_Grafica
figure
x = [1 2 3 -4 5]; y = [6 -1 7 9 -2];
plot(x, y, 'r--p')
title('Esto es una grafica')
xlabel('Eje X')
ylabel('Eje Y')
text(-2,0,'Esto es un texto')
grid on

%2 Funciones Diferentes:
figure
x = 0:pi/100:3*pi; y = cos(x); z = cos(3*x);
plot(x, y, x, z)
legend('f(x)=cos x','g(x)=cos(3x)')

%Ejercicio sobre el comando "plot":
figure
x = 0:pi/100:2*pi;
y = sin(x);
plot(x, y)
hold on
z = cos(x);
plot(x, z, 'g-.')
hold off

%Circunferencia:
figure
t = 0:pi/180:2*pi; 
x = cos(t); 
y = sin(t); 
plot(x,y)
axis equal
axis tight
axis([-4 4 -2 2])

%Funcion:
figure
x = linspace(-2, 3, 1000);
y = (1-2*x).*(x <= -1)+((x + 1).^3 + 2*x).*(x > -1);
plot(x, y, '.');
title('funcion definida a trozos')