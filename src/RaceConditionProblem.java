//todo - simulate the race condition problem here
// and the solution with commenting previous state.
public class RaceConditionProblem implements Runnable {
    int ticketsAvailable=1;

    public void run(){

        System.out.println("Waiting to book ticket for : "+Thread.currentThread().getName());
        if(ticketsAvailable>0){
            System.out.println("Booking ticket for : "+Thread.currentThread().getName());


            try{
                Thread.sleep(1000);
            }catch(Exception e){}

            ticketsAvailable--;
            System.out.println("Ticket BOOKED for : "+ Thread.currentThread().getName());
            System.out.println("currently ticketsAvailable = "+ticketsAvailable);
        }
        else{
            System.out.println("Ticket NOT BOOKED for : "+ Thread.currentThread().getName());
        }


    }
}
//Race condition PROBLEM: 1 ticked was booked for 2 passengers

/*We will try to solve this race condition problem with synchronized block
*Program to show that with synchronization no problems will happen when 2 passengers try to book train ticked,
* while only one ticket available for sale*/

//Here is the solution for above problem
/*
* public void run(){

           System.out.println("Waiting to book ticket for : "+Thread.currentThread().getName());
           synchronized (this) {
                  if(ticketsAvailable>0){
                        System.out.println("Booking ticket for : "+Thread.currentThread().getName());


                        try{
                               Thread.sleep(1000);
                        }catch(Exception e){}

                        ticketsAvailable--;
                        System.out.println("Ticket BOOKED for : "+ Thread.currentThread().getName());
                        System.out.println("currently ticketsAvailable = "+ticketsAvailable);
                  }
                  else{
                        System.out.println("Ticket NOT BOOKED for : "+
                                  Thread.currentThread().getName());
                  }

           }//End synchronization block


    }

* */

// ATCTT3xFfGN0dWSrNtlJBoeg6WmzRPuhekCptYzsDShCO-dNoyjjuHKVtfc8na_ly5cppJyd377R7aTfIv9fy2k-zZwvumzimLn_nLIPVMnJD0PN6W6EchQtSUMqVnpH84c578__Dxr_DHsnaqePJW9hzAZ2SMTjUCZA2uHZ8XfAYMDc5OlnXNY=DE03480B
