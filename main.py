# This is a sample Python script.

# Press ⌃R to execute it or replace it with your code.
# Press Double ⇧ to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press ⌘F8 to toggle the breakpoint.


def handle_user_choice(user_choise: str, bank: dict):
    if user_choise == "1":
        update_spend(bank)
    elif user_choise == "2":
        bank.items()
    elif user_choise == "3":
        bank = counting(bank)
    return bank


def handle_user_choice1(user_choise: str, bank: dict):
    if user_choise == "4":
        update_spend(bank)
    elif user_choise == "5":
        bank.items()
    elif user_choise == "6":
        bank = counting(bank)
    return bank


def end_month(spend: dict, salary: dict):
    final_result = counting(salary) - counting(spend)


def update_spend(bank: dict):
    new = input("Please enter your spend name end the value like this <name,value>:")
    name = new.split(",")[0]
    value = new.split(",")[1]
    bank[name] = int(value)
    return bank


def your_choice():
    choice = input("pls enter your choice \n 1.add spend\n2.print spend"
                   "\n3.counting spend")
    return choice


def your_choice1():
    choice = input("pls enter your choice \n1.counting income\n2.add income"
                   "\n3.print income")
    return choice


def counting(spending: dict):
    value = spending.values()
    total = sum(value)
    print(total)
    return total


def main():

    spend = {}
    salary = {}
    while True:
        hello = input("1.to apdate spend print \n2.toapdate salary \n"
                      "3.if you wont to see the month report")
        if hello == "1":
            user_choise = your_choice()
            spend = handle_user_choice(user_choise, spend)
        elif hello == "2":
            user_choise1 = your_choice()
            spend = handle_user_choice1(user_choise, salary)
        elif hello == "3":
            report = counting(salary) - counting(spend)
            print("the salary this month is:", counting(salary), "the many you spend is:", counting(spend),
                  "the final is:", report)



if __name__ == '__main__':
    main()

value = {"jrc": 45, "jrc": 45}
dictionary = {'george': 16, 'amber': 19}



# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
