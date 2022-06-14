import React, {useEffect, useState} from "react";
import TaskOutput from "./TaskOutput";
import {Task} from "./model";
import './Style.css';
import InputNewTask from "./InputNewTask";
import axios from "axios";

export default function Card() {

    const [list, setList] = useState<Task[]>([]);

    const [error, setError] = useState("")

    function refresh() {
        axios.get("http://localhost:8080/api/react", {})
            .then(response => response.data)
            .then(tasks => setList(tasks))
            .catch(err => setError("error"));
    }

    useEffect(() => {
        refresh();
    }, []);


    const getList = () => {
        return list.map(t => <TaskOutput task={t}/>)
    }

    return (
        <div>
            <div className="input-card">
                <InputNewTask refreshFunction={refresh}/>
            </div>

            <div className={"tasks-headline"}>
                <h2><u>Aufgaben:</u></h2>
                {getList()}

            </div>
        </div>
    )
}