package ru.hw_team.lev.ui.basefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Oleg Illiashenko
 *         Email: ctanok@gmail.com
 *         Date: 20.08.13                         CTR+alt+shift+s
 *
 *         пример использования наследования, мы создаем родительский фрагмент от которого наследуем все свои фрагменты
 *         в приложении. Зачем это ? Для того чтоб могли вынести необходимые методы в этот клас и использовать их повторно
 *         во всех дочерних классах
 *
 *         В юудущем приделаем с его помощью навигатию через actionBar
 */
public abstract class BaseFragment extends Fragment {

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(getLayoutResource(), null);
//        return view;
//    }
//
//    protected abstract int getLayoutResource();
}
