import { useState } from 'react';

export default function AgeHeightWeight({ onNext, gymProficiency }) {
    const [age, setAge] = useState('');
    const [height, setHeight] = useState('');
    const [currentWeight, setCurrentWeight] = useState('');
    const [goalWeight, setGoalWeight] = useState('');

    const handleSubmit = () => {
        const data = {
            age,
            height,
            currentWeight,
            goalWeight,
            gymProficiency,
        };

        onNext(data);
    };

    return (
        <div className="space-y-4">
            <input
                type="number"
                placeholder="Age"
                value={age}
                onChange={(e) => setAge(e.target.value)}
                className="border p-2 rounded"
            />
            <input
                type="number"
                placeholder="Height (cm)"
                value={height}
                onChange={(e) => setHeight(e.target.value)}
                className="border p-2 rounded"
            />
            <input
                type="number"
                placeholder="Current Weight (kg)"
                value={currentWeight}
                onChange={(e) => setCurrentWeight(e.target.value)}
                className="border p-2 rounded"
            />
            <input
                type="number"
                placeholder="Goal Weight (kg)"
                value={goalWeight}
                onChange={(e) => setGoalWeight(e.target.value)}
                className="border p-2 rounded"
            />
            <button onClick={handleSubmit} className="bg-blue-500 text-white p-2 rounded">Next</button>
        </div>
    );
}