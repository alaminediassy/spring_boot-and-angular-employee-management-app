import Image from "next/image";
import StudentList from "./Components/StudentList";

export default function Home() {
  return (
    <>
      <h1 className="text-center text-gray-500  text-xl font-bold pr-10 pl-10 pt-10 pb-2">
        BiENVENUE SUR NOTRE APPLICATION
      </h1>
      <StudentList />
    </>
  );
}
