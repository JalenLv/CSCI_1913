import pandas as pd
import matplotlib.pyplot as plt


def plot_sort_data(csv_file, title):
    df = pd.read_csv(csv_file)

    # Strip out potential whitespace in column headers
    df.columns = df.columns.str.strip()

    plt.figure()

    plt.plot(df["length"], df["selection"], label="Selection", marker="o", markersize=2)
    plt.plot(df["length"], df["insertion"], label="Insertion", marker="x", markersize=2)
    plt.plot(df["length"], df["merge"], label="Merge", marker="s", markersize=2)

    plt.xlabel("List Length")
    plt.ylabel("Operations/Time")
    plt.title(title)

    plt.legend()

    plt.savefig(f"{title}.png", dpi=300)
    plt.close()


plot_sort_data("backwards.csv", "Backwards")
plot_sort_data("near_sorted.csv", "Near Sorted")
plot_sort_data("random.csv", "Random")
plot_sort_data("sorted_list.csv", "Already Sorted")

plt.show()
