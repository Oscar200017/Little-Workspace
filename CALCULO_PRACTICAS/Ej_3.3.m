%Ejercicio_3.3:
pkg load symbolic
syms t
v(t) = 0.001302*t^3 - 0.09029*t^2 + 23.61*t - 3.083
subplot(1,3,1)
ezplot(v(t), [0,126])
