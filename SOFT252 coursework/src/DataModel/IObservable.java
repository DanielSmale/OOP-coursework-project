/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;
/**
 *
 * @author Student
 */
public interface IObservable {

public void RegisterObserver(IObserver observer);
public void RemoveObserver(IObserver observer);
public void NotifiyObservers();


}
