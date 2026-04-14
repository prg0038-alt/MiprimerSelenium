# Tarea Evaluación Módulo 16.1 - Parte 5: Cuestiones

##  ¿Qué hace la anotación `@BeforeEach`?

La anotación `@BeforeEach` infica que ese método se ejecuta antes de cada test.

### Uso típico:
- Inicializar el navegador
- Preparar datos o variables
- Configurar el entorno de pruebas

Garantiza que cada test empiece desde un estado limpio.

---

##  ¿Para qué sirve `assertTrue` ?

`assertTrue` sirve para verificar que una condicion sea **verdadera**.

### Funcionamiento:
- Si la condición es `true`, el test continúa o pasa.
- Si la condición es `false`, el test falla.

### Ejemplo:
<img width="702" height="254" alt="imagen" src="https://github.com/user-attachments/assets/21155172-05a9-426b-9777-58d65ab10078" />

---

##  ¿Que diferencia hay entra 'findElement()' y 'findElements()'?

La diferencia esque el findElement() solo devuelve un elemento mientras que el findElements() debuelve varios. Tambien hay una diferencia en lo que devuelve si no encuentran un elemento y es que findElement() lanza una excepción mientras que findElements() debuelve una lista vacia. 

---

## ¿Porque utilizamos una clase 'LoginPage' en lugar de escribir todo en el test? 

porwue aplicamos el patrón de diseño Page Object Model (POM), que consiste en separar la lógica de lla página del código de los tests. 

En lugar de escribir directamente las acciones de navegador dentro del test, las agrupamos en una clase específica que representa la página. Esto hace que el codigo sea mucho mas eficiente porque podemos usar el mismo login en muchos tests sin tener que repetir en coadigo y facilita el mantenimiento porque si tenemos que cambiar algo del codigo, solo es necesario cambiar una cosa no todos los test. 

Otra ventaja seria que el codigo estaria mas limpio y mas faciles de leer por lo que se evitarian los duplicados.

---

# Capturas

##Test 
<img width="1357" height="901" alt="image" src="https://github.com/user-attachments/assets/c4765148-7050-4533-aaca-7d54699d03f1" />

<img width="1190" height="487" alt="image" src="https://github.com/user-attachments/assets/853ae7fc-a2b4-487a-8e8c-99cf9c6ddccc" />

##LonginPage
<img width="946" height="1101" alt="image" src="https://github.com/user-attachments/assets/00bb7359-bf63-4fd6-a9f2-d43837aa8c86" />

<img width="1090" height="1022" alt="image" src="https://github.com/user-attachments/assets/11b3111c-aa9f-4a49-a4c9-efc7a098a0f4" />

