public class AVL
{
    Nodo Raiz;

    public AVL()
    {
        Raiz = null;
    }

    private Nodo Insertar(Nodo padre, int valor)
    {
        if(padre == null)
        {
            padre = new Nodo(valor);
        }
        else if(valor < padre.Valor)
        {
            padre.Izquierdo = Insertar(padre.Izquierdo, valor);
        }else if(valor > padre.Valor)
        {
            padre.Derecho = Insertar(padre.Derecho, valor);
        }

        padre = Balancear(padre);

        return padre;
    }

    public Nodo Agregar(int valor)
    {
        Raiz = Insertar(Raiz, valor);
        return Raiz;
    }

    private Nodo Balancear(Nodo padre)
    {
        if (padre != null) {
            int ladoIzquierdo = GetAltura(padre.Izquierdo);
            int ladoDerecho = GetAltura(padre.Derecho);

            int desbalance = ladoIzquierdo - ladoDerecho;

            if (padre.Derecho != null)
            {
                if (desbalance == -2 && padre.Derecho != null) {
                    //DerechaIzquierda
                } else {
                    //Rotacion Izquierda
                }
            } else if (padre.Izquierdo != null)
            {
                if (desbalance == 2 && padre.Izquierdo != null) {
                    //IzquierdaDerecha
                } else {
                    //Rotacion Derecha
                }
            }
        }

        return null;
    }

    private int GetAltura(Nodo nodoActual)
    {
        if(nodoActual == null)
            return 0;

        int ladoDerecho = GetAltura(nodoActual.Derecho);
        int ladoIzquierdo = GetAltura(nodoActual.Izquierdo);

        if(ladoDerecho > ladoIzquierdo)
            return ladoDerecho + 1;
        else
            return ladoIzquierdo + 1;

    }

}
